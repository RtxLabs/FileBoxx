package de.rotex.fileboxx

class TagListVo {

    long id
    String name

	static TagListVo bind(TagList list) {
        return new TagListVo(id: list.id, name: list.name)
    }
}

