Ext.define("de.rotex.fileboxx.view.tag.TagCloudView", {
    extend: "Ext.view.View",
    alias: "widget.tagcloud",

    store: "TagStore",
    itemSelector: 'div.thumb-wrap',

    tpl: new Ext.XTemplate(
        '<tpl for=".">',
            '<span class="fileboxx-tag" ',
                'style="font-size: {fontSize}em">',
                ' {name} ',
            '</span>',
        '</tpl>'
    ),

    prepareData: function(data) {
        data.fontSize = 0.5 +
            3 * (data.fileCount / this.store.countFiles());
        return data;
    },

    initComponent: function() {
        this.callParent(arguments);
    }
});