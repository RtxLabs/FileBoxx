Ext.define("de.rotex.fileboxx.controller.FileBoxxFileController", {
    extend: "Ext.app.Controller",
    views: ["file.FileBoxxFilesView", "file.FileBoxxFileEditView"],
    stores: ["FileBoxxFileStore"],
    models: ["FileBoxxFile"],

    init: function() {
        this.control({
            'dataview': {
                remove: function(record) {
                    var store = this.getStore("FileBoxxFileStore");
                    store.remove(record);
                    store.sync();
                }
            }
        });
    }
});