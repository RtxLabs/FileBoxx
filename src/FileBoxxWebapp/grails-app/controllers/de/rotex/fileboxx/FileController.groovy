package de.rotex.fileboxx

import grails.converters.JSON

class FileController {

    def create = {
        def document = Document.get(params["documentId"])
        params["file"].transferTo(document.file);
        response.sendError(200, "Done")
    }

    def read = {
        def document = Document.get(params["id"])

        if (document != null && document.file.exists()) {
            response.setContentType("application/octet-stream")
            response.setHeader("Content-disposition", "attachment;filename=${document.name}")
            response.outputStream << document.file.newInputStream()
        }
    }
}
