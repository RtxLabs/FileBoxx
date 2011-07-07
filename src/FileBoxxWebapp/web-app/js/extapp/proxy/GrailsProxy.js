Ext.define("de.rotex.fileboxx.proxy.GrailsProxy", {
    extend: "Ext.data.proxy.Rest",
    alias: "proxy.grails",

    buildUrl: function(request) {
        var operation = request.operation;

        if (operation.action == "read" && !operation.id) {
            request.url = this.getUrl(request) + "s";
        }

        return this.callParent(arguments);
    }
});