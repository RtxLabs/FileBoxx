Ext.define("de.rotex.fileboxx.store.TagListStore", {
   extend: "Ext.data.Store",
   requires : ["de.rotex.fileboxx.proxy.GrailsProxy"],

   model: "de.rotex.fileboxx.model.TagList",
   
   proxy: {
       type: "grails",
       url: "tagList",
       reader: {
           type: "json"
       }
   }
});