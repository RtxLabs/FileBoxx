package de.rotex.fileboxx

class FileBoxxFile {
	String name
    String description
    Date createdAt = new Date()
    User createdBy

    static hasMany = [tags: Tag]

    static constraints = {
        name(blank: false)
        description(blank: false)
    }

    def beforeInsert() {
        createdAt = new Date()
    }
}

