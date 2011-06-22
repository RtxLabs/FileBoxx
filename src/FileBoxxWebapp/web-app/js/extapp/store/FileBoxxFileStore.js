Ext.define("de.rotex.fileboxx.store.FileBoxxFileStore", {
   extend: "Ext.data.Store",
   model: "de.rotex.fileboxx.model.FileBoxxFile",
   autoLoad: true,
   
   proxy: {
       type: "rest",
       url: "fileBoxxFile",
       reader: {
           type: "json",
           root: "data",
           successProperty: "success"
       }
   }
});