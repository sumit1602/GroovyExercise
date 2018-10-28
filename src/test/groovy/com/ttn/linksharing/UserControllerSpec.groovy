package com.ttn.linksharing

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController> {
    def "test for User action index"() {
        when:
        controller.index()
        then:
        response.contentAsString == "user dashboard"
    }


}
