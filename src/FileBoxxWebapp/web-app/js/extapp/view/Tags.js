Ext.define("de.rotex.fileboxx.view.Tags", {
    extend: "Ext.form.field.Text",
    alias: "widget.tagsfield",

    tags: null,

    rawToValue: function(rawValue) {
        var value = new Array();

        for each (var tag in rawValue.split(",")) {
            value.push(Ext.String.trim(tag));
        }

        return value;
    },

    valueToRaw: function(value) {
        if (value instanceof Array) {
            return value.join(", ");
        }
        else {
            this.callParent(value);
        }
    }
});