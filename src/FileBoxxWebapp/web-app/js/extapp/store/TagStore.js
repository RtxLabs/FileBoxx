Ext.define("de.rotex.fileboxx.store.TagStore", {
   extend: "Ext.data.Store",
   model: "de.rotex.fileboxx.model.Tag",
   autoLoad: true,
   
   proxy: {
       type: "rest",
       url: "tag",
       reader: {
           type: "json"
       }
   },

   countFiles: function() {
       return 5;
   }
});