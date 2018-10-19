package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import groovy.mock.interceptor.MockFor
import org.springframework.boot.test.context.TestComponent
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification
import spock.lang.Unroll
import spock.util.mop.Use

class UserSpec extends Specification implements DomainUnitTest<User> {
    @Unroll
    def "validate user contraints firstname & lastname "() {
        when:
        User user = new User(firstName: FIRSTNAME, lastName: LASTNAME, email: EMAIL,
                password: PASSWORD, photo: Photo, active: ISACTIVE, admin: ADMIN)

        then:
        user.validate() == status

        where:
        FIRSTNAME      | LASTNAME             | EMAIL                          | PASSWORD   | Photo        | ISACTIVE | ADMIN | status
        "sumit"        | "chaudhary"          | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | true
        "sumit"        | null                 | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | false
        null           | "chaudhary"          | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | false
        "sumit"        | ""                   | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | false
        ""             | "chaudhary"          | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | false
        null           | null                 | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | false
        "sumit"        | "1!@%^&*()chaudhary" | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | true
        "!@#%^&*sumit" | "chaudhary"          | "sumit.chaudhary@tothenew.com" | "abcd1234" | "sumit".bytes | true     | true  | true


    }

//    @Unroll
//    def "validate user contraints for unique email "() {
//        when:
//        User user = new User(firstName: "ggyu", lastName: "bhjj", email: "a@b.com",
//                password: "abcd1234", photo: "sumit".bytes, active: true, admin: true)
//        User user1 = new User( lastName: "bhjj", email: "a@b.com",
//                password: "abcd1234", photo: "sumit".bytes, active: true, admin: true)
//        then:
//        user.save() instanceOf User
//        user1.save() == null
//        user1.hasErrors()
//       user1.errors.allErrors.each {println(it)}
//
//
////        where:
////        FIRSTNAME | LASTNAME    | EMAIL                          | PASSWORD           | Photo        | ISACTIVE | ADMIN | status
////        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "abcd1234"         | "sumit".bytes | true     | true  | true
////        "sumit"   | "chaudhary" | "sumit1.chaudhary@tothenew.com" | "!@#%^&*()_+!@#"   | "sumit".bytes | true     | true  | true
////        "sumit"   | "chaudhary" | "sumit2.chaudhary@tothenew.com" | "123456789123456"  | "sumit".bytes | true     | true  | true
////        "sumit"   | "chaudhary" | "sumit3.chaudhary@tothenew.com" | 12345              | "sumit".bytes | true     | true  | true
////        "sumit"   | "chaudhary" | "sumit4.chaudhary@tothenew.com" | "-------"          | "sumit".bytes | true     | true  | true
//    }

    @Unroll
    def "validate user contraints password "() {
        when:
//        User user = new User(firstName: FIRSTNAME, lastName: LASTNAME, email: EMAIL,
//                password: PASSWORD, photo: Photo, active: ISACTIVE, admin: ADMIN)

        User user = new User(firstName: FIRSTNAME, lastName: LASTNAME, email: EMAIL,
                password: PASSWORD, photo: Photo, active: ISACTIVE, admin: ADMIN)
        then:
        user.validate() == status

        where:
        FIRSTNAME | LASTNAME    | EMAIL                          | PASSWORD           | Photo         | ISACTIVE | ADMIN | status
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "abcd1234"         | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "!@#%^&*()_+!@#"   | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "123456789123456"  | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | 12345              | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"          | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "      "           | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "abc"              | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | 0000               | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "1"                | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "1234567891234567" | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | ""                 | "sumit".bytes | true     | true  | false
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | null               | "sumit".bytes | true     | true  | false

    }

    @Unroll
    def "validate user contraints photo, admin & active"() {
        when:
        User user = new User(firstName: FIRSTNAME, lastName: LASTNAME, email: EMAIL,
                password: PASSWORD, photo: Photo, active: ISACTIVE, admin: ADMIN)

        then:
        user.validate() == status

        where:
        FIRSTNAME | LASTNAME    | EMAIL                          | PASSWORD          | Photo         | ISACTIVE | ADMIN | status
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "123456789123456" | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | null          | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "".bytes      | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | 12345             | "sumit".bytes | true     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "sumit".bytes | false    | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "sumit".bytes | null     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "sumit".bytes | null     | true  | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "sumit".bytes | null     | false | true
        "sumit"   | "chaudhary" | "sumit.chaudhary@tothenew.com" | "-------"         | "sumit".bytes | null     | null  | true


    }

}
