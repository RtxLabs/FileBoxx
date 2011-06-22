Ext.define("de.rotex.fileboxx.view.HeaderView", {
    extend: "Ext.container.Container",
    alias: "widget.fbheader",
    html: "header",

    initComponent: function() {
        this.html = "<h1>FileBoxx</h1>";
        this.callParent(arguments);
   }
});