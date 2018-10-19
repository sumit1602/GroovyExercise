package com.ttn.linksharing.enums.Visibility

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
}
