package de.rotex.fileboxx

class FileBoxxFileVo {

    long id
    String name
    String description
    List tagNames
    Date createdAt
    String createdByName

	static FileBoxxFileVo bind(FileBoxxFile file) {
        def vo = new FileBoxxFileVo(
            id: file.id,
            name: file.name,
            description: file.description,
            createdAt: file.createdAt,
            createdByName: file.createdBy.username
        )

        vo.tagNames = file.tags.collect {it.name}

        return vo
    }
}

