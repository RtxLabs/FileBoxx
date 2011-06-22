Ext.define("de.rotex.fileboxx.view.file.FileBoxxFileEditView", {
    extend: "Ext.window.Window",
    alias: "widget.fileedit",

    title: "Datei bearbeiten",
    layout: "fit",
    modal: true,
    autoShow: true,
    resizable: false,

    items: [{
        xtype: "form",
        bodyPadding: 5,
        defaults: {
            anchor: '100%'
        },
        items: [{
            xtype: "textfield",
            name: "description",
            fieldLabel: "Beschreibung"
        }, {
            xtype: "filefield",
            name: "file",
            fieldLabel: "Datei",
            width: 400
        }]
    }],

    buttons: [{
        text: "Speichern",
        action: "save"
    }, {
        text: "Abbrechen",
        scope: this,
        handler: function () {
            this.close();
        }
    }]
});