Ext.define("de.rotex.fileboxx.controller.TagController", {
    extend: "Ext.app.Controller",
    views: ["tag.TagView", "tag.TagListView", "tag.TagCloudView"],
    stores: ["TagListStore", "TagStore"],
    models: ["Tag", "TagList"]
});