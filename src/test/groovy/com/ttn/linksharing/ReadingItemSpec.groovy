package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class ReadingItemSpec extends Specification implements DomainUnitTest<ReadingItem> {
@Unroll
    def "Reading item constaints isread"() {
        when:
        ReadingItem readingItem = new ReadingItem(user: USER, resource: RESOURCE, isRead: IS_READ)

        then:
        readingItem.validate() == status

        where:

        USER       | RESOURCE           | IS_READ | status
        new User() | new LinkResource() | true    | true
        new User() | new LinkResource() | false   | true
        new User() | new LinkResource() | null    | false
    }
    @Unroll
    def "Reading item constaints USER & RESOURCE"() {
        when:
        ReadingItem readingItem = new ReadingItem(user: USER, resource: RESOURCE, isRead: IS_READ)

        then:
        readingItem.validate() == status

        where:

        USER       | RESOURCE           | IS_READ | status
        new User() | new LinkResource() | true    | true
        null       | new LinkResource() | false   | false
        new User() | null               | true   | false
        null       | null               | false   | false
    }


}
