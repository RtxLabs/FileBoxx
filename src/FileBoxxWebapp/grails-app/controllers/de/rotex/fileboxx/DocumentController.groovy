package de.rotex.fileboxx

import grails.converters.JSON

class DocumentController {

    def springSecurityService

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        def result = [success: true]
        result.data = Document.list(params)

        render result as JSON
    }

    def delete = {
        def result = [:]

        def document = Document.get(params.id)
        if (document) {
            document.delete(flush: true)
            result.success = true
        }
        else {
            result.success = false
            result.message = "document does not exist"
        }

        render result as JSON
    }

    def create = {
        def result = [:];

        //TODO: workaround for grails bug 5585 (http://jira.grails.org/browse/GRAILS-5585)
        def documentJSON = NullUnwrapper.prepareForBinding(params["documentVo"])
        def documentVo = new DocumentVo(documentJSON)
        def currentUser = springSecurityService.currentUser

        def document = new Document(
            createdBy: currentUser,
            description: documentVo.description,
            name: documentVo.name
        )

        document.addTagsByName(new HashSet<String>(documentVo.tagNames))

        if (document.validate()) {
            document.save()
            result.success = true
            result.data = DocumentVo.bind(document)
        }
        else {
            result.success = false
            result.data = document.errors
        }

        render result as JSON
    }

    def update = {
        def result = [:];

        def documentJSON = NullUnwrapper.prepareForBinding(params["documentVo"])
        def documentVo = new DocumentVo(documentJSON)
        def currentUser = springSecurityService.currentUser

        def document = Document.get(documentVo.id)

        document.description = documentVo.description
        document.name = documentVo.name

        document.tags.clear()
        document.addTagsByName(new HashSet<String>(documentVo.tagNames))

        if (document.validate()) {
            document.save()
            result.success = true
            result.data = DocumentVo.bind(document)
        }
        else {
            result.success = false
            result.data = document.errors
        }

        render result as JSON
    }

//
//    def update = {
//        def fileBoxxFileInstance = FileBoxxFile.get(params.id)
//        if (fileBoxxFileInstance) {
//            if (params.version) {
//                def version = params.version.toLong()
//                if (fileBoxxFileInstance.version > version) {
//                    
//                    fileBoxxFileInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile')] as Object[], "Another user has updated this FileBoxxFile while you were editing")
//                    render(view: "edit", model: [fileBoxxFileInstance: fileBoxxFileInstance])
//                    return
//                }
//            }
//            fileBoxxFileInstance.properties = params
//            if (!fileBoxxFileInstance.hasErrors() && fileBoxxFileInstance.save(flush: true)) {
//                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), fileBoxxFileInstance.id])}"
//                redirect(action: "show", id: fileBoxxFileInstance.id)
//            }
//            else {
//                render(view: "edit", model: [fileBoxxFileInstance: fileBoxxFileInstance])
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//            redirect(action: "list")
//        }
//    }
}
