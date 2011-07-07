package de.rotex.fileboxx

import grails.converters.JSON
import grails.test.ControllerUnitTestCase

class TagListControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testList() {
        def list1 = new TagList(id: 1, name: "Webservice")
        def list2 = new TagList(id: 2, name: "Service")
        def list3 = new TagList(id: 3, name: "Marketing")
        mockDomain(TagList, [list1, list2, list3])

        def controller = new TagListController()
        controller.params.sort = "name"
        controller.list()

        def expected = [
            TagListVo.bind(list3),
            TagListVo.bind(list2),
            TagListVo.bind(list1)] as JSON

        assertEquals expected.toString(), controller.response.contentAsString
    }
}
