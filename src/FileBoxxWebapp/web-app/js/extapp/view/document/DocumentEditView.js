Ext.define("de.rotex.fileboxx.view.document.DocumentEditView", {
    extend: "Ext.window.Window",
    alias: "widget.documentedit",

    title: "Datei bearbeiten",
    plain: true,
    width: 450,
    modal: true,
    autoShow: true,
    resizable: false,

    initComponent: function() {
        this.items = [{
            id: "documentForm",
            xtype: "form",

            bodyPadding: "5 5 0 5",
            border: false,
            defaults: {
                anchor: '100%'
            },
            items: [{
                xtype: "textfield",
                name: "description",
                fieldLabel: "Beschreibung"
            }, {
                xtype: "tagsfield",
                name: "tagNames",
                fieldLabel: "Tags"
            }]
        }, {
            id: "fileForm",
            xtype: "form",

            bodyPadding: "0 5 5 5",
            border: false,
            defaults: {
                anchor: "100%"
            },
            items: [{
                id: "fileField",
                xtype: "filefield",
                name: "file",
                fieldLabel: "Datei",
                width: 400
            }]
        }];

        this.buttons = [{
            id: "saveButton",
            text: "Speichern",
            action: "save"
        }, {
            text: "Abbrechen",
            scope: this,
            handler: this.close
        }];

        this.callParent(arguments);
    }
});