Ext.define("de.rotex.fileboxx.store.DocumentStore", {
    extend: "Ext.data.Store",
    requires : ["de.rotex.fileboxx.proxy.GrailsProxy"],

    model: "de.rotex.fileboxx.model.Document",
    autoLoad: true,

    proxy: {
        type: "grails",
        url: "document",
        reader: {
            type: "json",
            root: "data",
            successProperty: "success"
        }
    }
});