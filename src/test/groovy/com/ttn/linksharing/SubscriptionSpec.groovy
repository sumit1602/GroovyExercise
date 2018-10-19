package com.ttn.linksharing.enums.Seriousness


import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Seriousness
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class SubscriptionSpec extends Specification implements DomainUnitTest<Subscription> {
@Unroll
    def "Validate subscription constraint" () {
        when:
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness )

        then:
        subscription.validate()== status

        where:
        topic       | user       | seriousness              | status
        new Topic() | new User() | Seriousness.SERIOUS      | true
        new Topic() | new User() | Seriousness.VERY_SERIOUS | true
        new Topic() | new User() | Seriousness.CASUAL       | true

//        new Topic() | new User() | com.ttn.linksharing.enums.Seriousness.CASUAL       | true
//        new Topic() | new User() | com.ttn.linksharing.enums.Seriousness.SERIOUS      | true
//        new Topic() | new User() | com.ttn.linksharing.enums.Seriousness.VERY_SERIOUS | true

    }
}
