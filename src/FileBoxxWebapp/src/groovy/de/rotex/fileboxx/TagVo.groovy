package de.rotex.fileboxx

class TagVo {
    long id
    String name
    int documentCount

	static TagVo bind(Tag tag) {
        return new TagVo(
            id: tag.id,
            name: tag.name,
            documentCount: tag.documents.size()
        )
    }
}

