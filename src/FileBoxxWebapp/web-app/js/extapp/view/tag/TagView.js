Ext.define("de.rotex.fileboxx.view.tag.TagView", {
    extend: "Ext.panel.Panel",
    alias: "widget.tagview",

    layout: {
        type: "vbox",
        align: "stretch",
        padding: 5
    },

    items: [{
        xtype: "combobox",
        store: "TagListStore",
        displayField: "name",
        valueField: "id"
    }, {
        xtype: "textfield"
    }, {
        xtype: "tagcloud"
    }],

    initComponent: function() {
        this.callParent(arguments);
    }
});