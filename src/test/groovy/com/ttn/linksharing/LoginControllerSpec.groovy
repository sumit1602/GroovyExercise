package com.ttn.linksharing

import grails.testing.gorm.DataTest
import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LoginControllerSpec extends Specification implements ControllerUnitTest<LoginController>, DomainUnitTest<User> {


    def "login index action "() {
        when:"session user is not present"
        controller.index()
        session['user'] == null

        then:
        response.contentAsString == "SESSION.USER DOESN'T EXIST"

    }

    def "login index action if part "() {
        when: "session user is present"
        session['user'] = new User()
        controller.index()

        then:
        response.forwardedUrl == '/user/index'
    }

    def "test for logout action"() {

        when:
        controller.logout()

        then:
        response.redirectUrl == '/login/index'
    }

    def "test case of login handler active = true"() {

        setup:
        User user = new User(firstName: "sumit", lastName: "chaudhary", email: "sumit.chaudhary@tothenew.com",
                password: Constant.password, admin: true, active: true)
        user.save()
        when:

        user.active = true
        controller.loginHandler(user.email, user.password)


        then:
        response.redirectUrl == '/login/index'
    }

    def "test case of login handler active = false"() {

        setup:
        User user = new User(firstName: "sumit", lastName: "chaudhary", email: "sumit.chaudhary@tothenew.com",
                password: Constant.password, admin: true, active: false)
        user.save()
        when:

        user.active = false
        controller.loginHandler(user.email, user.password)


        then:
        response.contentAsString == 'Your account is not active'
    }
    def "test case for loginhandler if user not present"(){
        setup:
        User user = new User()
        user.save()
        when:
        controller.loginHandler(user.email, user.password)

        then:
        response.contentAsString == "User not found"
    }
}
