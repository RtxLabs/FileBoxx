package de.rotex.fileboxx

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.codehaus.groovy.grails.web.json.JSONObject

class Document {
	String name
    String description
    Date createdAt = new Date()
    User createdBy
    SortedSet tags

    static hasMany = [tags: Tag]

    static constraints = {
        name(blank: false)
        description(blank: false)
    }

    static Document bind(JSONObject json) {
        def document = new Document()

        if (json.id > 0) {
            document = Document.get(json.id)
        }

        document.description = json.description
        document.name = json.name
        document.addTagsByName(json.tagNames)
        document.version = json.version

        return document
    }

    def afterDelete() {
        def file = this.file
        if (file.exists()) {
            file.delete()
        }
    }

    def beforeInsert() {
        createdAt = new Date()
    }

    def addTagsByName(Set<String> tagNames) {
        tagNames.each { tagName ->
            def tag = Tag.findByName(tagName)

            if (!tag) {
                tag = new Tag(name: tagName)
            }

            addToTags(tag)
        }
    }

    def getFile() {
        return new File("${ConfigurationHolder.config.fileBoxx.fileUploadDir}/${id}");
    }
}

