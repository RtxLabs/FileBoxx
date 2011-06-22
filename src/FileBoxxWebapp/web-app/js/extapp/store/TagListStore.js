Ext.define("de.rotex.fileboxx.store.TagListStore", {
   extend: "Ext.data.Store",
   model: "de.rotex.fileboxx.model.TagList",
   
   proxy: {
       type: "rest",
       url: "tagList",
       reader: {
           type: "json"
       }
   }
});