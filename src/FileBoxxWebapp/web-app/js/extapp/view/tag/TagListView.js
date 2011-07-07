Ext.define("de.rotex.fileboxx.view.tag.TagListView", {
   extend: "Ext.container.Container",
   alias: "widget.taglist",

   initComponent: function() {
       this.html = "taglist";
       this.callParent(arguments);
   }
});