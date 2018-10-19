package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class ResourceRatingSpec extends Specification implements DomainUnitTest<ResourceRating> {
@Unroll
    def "Resource rating validation"() {
        when:
        ResourceRating resourceRating = new  ResourceRating(resource: RESOURCE, createdBy: CREATED_BY, score: SCORE)

        then:
        resourceRating.validate()==status

        where:
        RESOURCE           | CREATED_BY | SCORE   | status
        new LinkResource() | new User() | 1       | true
        new LinkResource() | new User() | 5       | true
        new LinkResource() | new User() | 2       | true
        new LinkResource() | new User() | null    | true
        new LinkResource() | new User() | -1      | false
        new LinkResource() | new User() | -5      | false
        new LinkResource() | new User() | -6      | false
        new LinkResource() | new User() | 0       | false
        new LinkResource() | new User() | +5      | false
        new LinkResource() | new User() | +6      | false
        new LinkResource() | new User() | "sumit" | false
        new LinkResource() | new User() | "5"     | false
    }


}
