package de.rotex.fileboxx

import grails.converters.JSON

class FileBoxxFileController {

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        def result = [success: true]
        result.data = FileBoxxFile.list(params).collect {
            FileBoxxFileVo.bind(it)
        }

        render result as JSON
    }

    def delete = {
        def result = [success: true]

        def fileBoxxFile = FileBoxxFile.get(params.id)
        if (fileBoxxFile) {
            fileBoxxFile.delete(flush: true)
        }
        else {
            result.success = false
            result.message = "file does not exist"
        }

        render result as JSON
    }

//    def create = {
//        def fileBoxxFileInstance = new FileBoxxFile()
//        fileBoxxFileInstance.properties = params
//        return [fileBoxxFileInstance: fileBoxxFileInstance]
//    }
//
//    def save = {
//        def fileBoxxFileInstance = new FileBoxxFile(params)
//        if (fileBoxxFileInstance.save(flush: true)) {
//            flash.message = "${message(code: 'default.created.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), fileBoxxFileInstance.id])}"
//            redirect(action: "show", id: fileBoxxFileInstance.id)
//        }
//        else {
//            render(view: "create", model: [fileBoxxFileInstance: fileBoxxFileInstance])
//        }
//    }
//
//    def show = {
//        def fileBoxxFileInstance = FileBoxxFile.get(params.id)
//        if (!fileBoxxFileInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            [fileBoxxFileInstance: fileBoxxFileInstance]
//        }
//    }
//
//    def edit = {
//        def fileBoxxFileInstance = FileBoxxFile.get(params.id)
//        if (!fileBoxxFileInstance) {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//            redirect(action: "list")
//        }
//        else {
//            return [fileBoxxFileInstance: fileBoxxFileInstance]
//        }
//    }
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
//
//    def delete = {
//        def fileBoxxFileInstance = FileBoxxFile.get(params.id)
//        if (fileBoxxFileInstance) {
//            try {
//                fileBoxxFileInstance.delete(flush: true)
//                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//                redirect(action: "list")
//            }
//            catch (org.springframework.dao.DataIntegrityViolationException e) {
//                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//                redirect(action: "show", id: params.id)
//            }
//        }
//        else {
//            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fileBoxxFile.label', default: 'FileBoxxFile'), params.id])}"
//            redirect(action: "list")
//        }
//    }
}
