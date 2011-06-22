Ext.define("de.rotex.fileboxx.controller.TagCloudController", {
    extend: "Ext.app.Controller",
    views: ["tag.TagCloudView"],
    stores: ["TagStore"],
    models: ["Tag"]
});