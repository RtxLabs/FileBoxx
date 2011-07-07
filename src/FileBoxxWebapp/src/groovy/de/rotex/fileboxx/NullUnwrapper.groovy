package de.rotex.fileboxx

import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * workaround for grails bug 5585 (http://jira.grails.org/browse/GRAILS-5585)
 *
 * User: uklawitter
 * Date: 27.06.11
 * Time: 10:16
 */
class NullUnwrapper {
    public static prepareForBinding(object) {
        def propertyMap = [:]

        object.each {
            if (!it.key.equals("class")) {
                propertyMap[it.key] = unwrap(it.value)
            }
        }

        return propertyMap
    }

    private static unwrap(value) {
        if (value == JSONObject.NULL) {
            return null
        }
        else {
            return value
        }
    }
}
