package de.rotex.fileboxx

import grails.test.ControllerUnitTestCase
import grails.converters.JSON
import grails.plugins.springsecurity.SpringSecurityService
import org.codehaus.groovy.grails.web.json.JSONObject

class DocumentControllerTests extends ControllerUnitTestCase {
    def controller
    def springSecurityService

    protected void setUp() {
        super.setUp()

        mockDomain(User)
        def user = new User(username: "uklawitter")
        user.save()

        springSecurityService = [currentUser: user]
        controller = new DocumentController()
        controller.springSecurityService = springSecurityService
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreate() {
        mockDomain(Document)
        mockDomain(Tag)

        def documentVo = new DocumentVo(description: "description", tagNames: ["tag1", "tag2"])

        controller.params.documentVo = new JSONObject(new JSON(documentVo).toString())
        controller.create()
    }
}
