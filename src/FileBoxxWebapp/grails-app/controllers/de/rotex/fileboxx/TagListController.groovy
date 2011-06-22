package de.rotex.fileboxx

import grails.converters.JSON

class TagListController {

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render TagList.list(params).collect {TagListVo.bind(it)} as JSON
    }

//    def create = {
//        def tagListInstance = new TagList()
//        tagListInstance.properties = params
//        return [tagListInstance: tagListInstance]
//    }
//
//    def save = {
//        def tagListInstance = new TagList(params)
//        if (tagListInstance.save(flush: true)) {
//            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tagList.label', default: 'TagList'), tagListInstance.id])}"
//            redirect(action: "show", id: tagListInstance.id)
//        }
//        else {
//            render(view: "create", model: [tagListInstance: tagListInstance])
//        }
//    }
//
//    def show = {
//        def tagListInstance = TagList.get(params.id)
//        if (!tagListInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            [tagListInstance: tagListInstance]
//        }
//    }
//
//    def edit = {
//        def tagListInstance = TagList.get(params.id)
//        if (!tagListInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            return [tagListInstance: tagListInstance]
//        }
//    }
//
//    def update = {
//        def tagListInstance = TagList.get(params.id)
//        if (tagListInstance) {
//            if (params.version) {
//                def version = params.version.toLong()
//                if (tagListInstance.version > version) {
//
//                    tagListInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tagList.label', default: 'TagList')] as Object[], "Another user has updated this TagList while you were editing")
//                    render(view: "edit", model: [tagListInstance: tagListInstance])
//                    return
//                }
//            }
//            tagListInstance.properties = params
//            if (!tagListInstance.hasErrors() && tagListInstance.save(flush: true)) {
//                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tagList.label', default: 'TagList'), tagListInstance.id])}"
//                redirect(action: "show", id: tagListInstance.id)
//            }
//            else {
//                render(view: "edit", model: [tagListInstance: tagListInstance])
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//            redirect(action: "list")
//        }
//    }
//
//    def delete = {
//        def tagListInstance = TagList.get(params.id)
//        if (tagListInstance) {
//            try {
//                tagListInstance.delete(flush: true)
//                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//                redirect(action: "list")
//            }
//            catch (org.springframework.dao.DataIntegrityViolationException e) {
//                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//                redirect(action: "show", id: params.id)
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tagList.label', default: 'TagList'), params.id])}"
//            redirect(action: "list")
//        }
//    }
}
