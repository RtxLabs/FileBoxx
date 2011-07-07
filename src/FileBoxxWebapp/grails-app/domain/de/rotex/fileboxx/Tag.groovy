package de.rotex.fileboxx

class Tag implements Comparable {

    String name

    static belongsTo = Document

    static hasMany = [documents: Document]

    static constraints = {
        name(blank: false, unique: true)
    }

    int compareTo(obj) {
        if (obj instanceof Tag) {
            return name.compareTo(obj.name)
        }

        return super.compareTo(obj)
    }
}
