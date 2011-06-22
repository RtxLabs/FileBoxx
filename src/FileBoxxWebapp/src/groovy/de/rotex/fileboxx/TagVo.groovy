package de.rotex.fileboxx

class TagVo {
    long id
    String name
    int fileCount

	static TagVo bind(Tag tag) {
        return new TagVo(
            id: tag.id,
            name: tag.name,
            fileCount: tag.fileBoxxFiles.size()
        )
    }
}

