package de.rotex.fileboxx

import org.codehaus.groovy.grails.web.json.JSONObject

class DocumentVo {

    long id
    String name
    String description
    List tagNames
    long version
    Date createdAt
    String createdByName

	static DocumentVo bind(Document document) {
        def vo = new DocumentVo(
            id: document.id,
            version: document.version,
            name: document.name,
            description: document.description,
            createdAt: document.createdAt,
            createdByName: document.createdBy.username
        )

        vo.tagNames = document.tags.collect {it.name}

        return vo
    }
}

