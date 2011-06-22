Ext.Loader.setConfig({enabled: true});

Ext.application({
    name: 'de.rotex.fileboxx',

    controllers: [
        "FileBoxxFileController",
        "HeaderController",
        "TagCloudController",
        "TagController",
        "TagListController"
    ],

    appFolder: 'js/extapp',

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [{
                region: "north",
                height: 60,
                xtype: "fbheader"
            }, {
                title: "Tags",
                region: "west",
                width: 266,
                xtype: "tagview"
            }, {
                title: "Dateien",
                region: "center",
                xtype: "fileboxxfiles",
                layout: "fit"
            }]
        });
    }
});