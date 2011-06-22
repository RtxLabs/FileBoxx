package de.rotex.fileboxx

class Tag {

    String name

    static belongsTo = FileBoxxFile

    static hasMany = [fileBoxxFiles: FileBoxxFile]

    static constraints = {
        name(blank: false, unique: true)
    }
}
