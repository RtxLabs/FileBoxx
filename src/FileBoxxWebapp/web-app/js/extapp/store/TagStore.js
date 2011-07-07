Ext.define("de.rotex.fileboxx.store.TagStore", {
   extend: "Ext.data.Store",
   requires : ["de.rotex.fileboxx.proxy.GrailsProxy"],

   model: "de.rotex.fileboxx.model.Tag",
   autoLoad: true,
   
   proxy: {
       type: "grails",
       url: "tag",
       reader: {
           type: "json"
       }
   },

   countDocuments: function() {
       return 5;
   }
});