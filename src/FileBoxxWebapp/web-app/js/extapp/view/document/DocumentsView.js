Ext.define("de.rotex.fileboxx.view.document.DocumentsView", {
    id: "documents-view",
    extend: "Ext.panel.Panel",
    alias: "widget.documents",
    title: "Dateien",
    store: "DocumentStore",

    dockedItems: [{
        xtype: "toolbar",
        dock: "bottom",
        items: [{
            xtype: "tbfill"
        }, {
            id: "insertDocumentButton",
            xtype: "button",
            text: "Eintrag einfügen",
            cls: "x-btn-text-icon",
            icon: "images/drive_add.png"
        }]
    }],

    items: [{
        // REFACTOR: create component
        xtype: "dataview",
        itemSelector: "div.fb-list-item",
        disableSelection: true,
        store: "DocumentStore",
        overItemCls: "hover",
        tpl: new Ext.XTemplate(
            '<tpl for=".">',
                '<div class="{[this.getClass(values, xindex)]}">',
                    '<span class="name">{description}</span> ({name})<br/>',
                    '{[this.getTagsString(values)]}<br/>',
                    'Erstellt von {createdByName} am {createdAt:this.formatDate}',
                    '<div class="fb-delete-btn" style="float: right"></div>',
                    '<div class="fb-edit-btn" style="float: right"></div>',
                    '<div class="fb-download-btn" style="float: right"></div>',
                '</div>',
            '</tpl>',
            {
                formatDate: function(date) {
                    return new Date(Date.parse(date)).toLocaleString();
                },
                getClass: function(values, rowNumber) {
                    if (rowNumber % 2 == 0) {
                        return "fb-list-item even"
                    }
                    else {
                        return "fb-list-item odd"
                    }
                },
                getTagsString: function(values) {
                    return values.tagNames.join(", ");
                }
            }
        ),
        listeners: {
            refresh: function(view) {
                this.getStore().each(function(record) {
                    var node = view.getNode(record);
                    Ext.create("Ext.Button", {
                        renderTo: Ext.query("div.fb-delete-btn", node)[0],
                        text: "Löschen",
                        handler: function() {
                            Ext.MessageBox.confirm(
                                "Bestätigen",
                                "Soll die Datei wirklich gelöscht werden?",
                                function(button) {
                                    if (button == "yes") {
                                        view.fireEvent("remove", record);
                                    }
                                }
                            );
                        }
                    });
                    Ext.create("Ext.Button", {
                        renderTo: Ext.query("div.fb-edit-btn", node)[0],
                        text: "Bearbeiten",
                        handler: function() {
                            view.fireEvent("edit", record);
                        }
                    });
                    Ext.create("Ext.Button", {
                        renderTo: Ext.query("div.fb-download-btn", node)[0],
                        text: "Download",
                        handler: function() {
                            view.fireEvent("download", record);
                        }
                    });
                });
            }
        }
    }],

    initComponent: function() {
        this.callParent(arguments);
    }
});