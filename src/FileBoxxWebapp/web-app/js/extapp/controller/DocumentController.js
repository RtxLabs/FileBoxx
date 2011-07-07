Ext.define("de.rotex.fileboxx.controller.DocumentController", {
    extend: "Ext.app.Controller",
    views: ["document.DocumentsView", "document.DocumentEditView", "Tags"],
    stores: ["DocumentStore"],
    models: ["Document"],

    init: function() {
        this.control({
            'dataview': {
                remove: function(record) {
                    var store = this.getStore("DocumentStore");
                    store.remove(record);
                    store.sync();
                },
                edit: function(record) {
                    var view = Ext.widget("documentedit");
                    view.down("#documentForm").loadRecord(record);
                },
                download: function(record) {
                    window.open("file/" + record.data.id, "_self");
                }
            },
            '#insertDocumentButton': {
                click: function() {
                    var view = Ext.widget("documentedit");
                    var record = Ext.ModelManager.create({}, "de.rotex.fileboxx.model.Document");

                    view.down("#documentForm").loadRecord(record);
                }
            },
            "#saveButton": {
                click: function(button) {
                    //REFACTOR cleanup
                    var windowEl = button.up("window");

                    var documentForm = windowEl.down("#documentForm").getForm();
                    var fileForm = windowEl.down("#fileForm").getForm();

                    var documentRecord = documentForm.getRecord();
                    var documentValues = documentForm.getFieldValues();
                    documentValues.name = windowEl.down("#fileField").getRawValue();
                    documentRecord.set(documentValues);

                    var documentStore = this.getStore("DocumentStore");
                    if (documentStore.indexOf(documentRecord) == -1) {
                        documentStore.add(documentRecord);
                    }

                    //WORKAROUND: feature 2126
                    documentStore.on("write",
                        function(store, operation) {
                            var createdRecord = operation.resultSet.records[0];

                            fileForm.url = "file";
                            fileForm.submit({
                                params: {
                                    documentId: createdRecord.data.id
                                },
                                success: function(form, action) {
                                    windowEl.close();
                                },
                                failure: function(form, action) {
                                    //TODO: handle failure
                                    windowEl.close();
                                }
                            });
                        }, this, {single: true}
                    );

                    documentStore.sync();
                }
            }
        });
    }
});