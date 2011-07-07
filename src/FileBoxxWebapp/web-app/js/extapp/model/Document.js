Ext.define("de.rotex.fileboxx.model.Document", {
   extend: "Ext.data.Model",
   fields: [
       {name: "id", type: "int", defaultValue: 0},
       {name: "class", type: "string", defaultValue: "de.rotex.fileboxx.DocumentVo"},
       {name: "name", type: "string", defaultValue: ""},
       {name: "description", type: "string", defaultValue: ""},
       {name: "tagNames", type: "array", defaultValue: new Array()},
       {name: "createdAt", type: "date", defaultValue: null},
       {name: "createdByName", type: "string", defaultValue: null}]
});