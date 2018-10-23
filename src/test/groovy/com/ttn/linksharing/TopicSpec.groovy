package com.ttn.linksharing.enums.Visibility

import com.ttn.linksharing.Constant
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class TopicSpec extends Specification implements DomainUnitTest<Topic> {

    @Unroll
    def "validate topic contraints  "() {
        when:
        User user = new User(email: "abc@gmail.com", password: "hjgsasdfefsas", firstName: "shdgads", lastName: "wqdhgqws", active: true, admin: true)
        Topic topic = new Topic(visibility: VISIBILITY, name: TOPICNAME, createdBy: user)

        then:
        topic.validate() == status

        where:
        VISIBILITY         | TOPICNAME | status
        Visibility.PRIVATE | "grails"  | true
        Visibility.PUBLIC  | "spring"  | true

    }

    @Unroll
    def "to check ToString of topic"() {
        given:
        User user = new User(email: "sumit.chaudhary@tothenew.com", password: Constant.password, firstName: "sumit", lastName: "chaudhary", photo: null,
                active: true, admin: false)

        when:
        Topic topic = new Topic(name: "Topic1", createdBy: user)

        then:
        topic.toString().equals("Name of Topic: Topic1 and userFullName: sumitchaudhary")

    }
}
