package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {
@Unroll
    def "validating linkResource url"() {
        when:
        LinkResource linkResource = new LinkResource(url: FILEPATH)

        then:
        linkResource.validate()== status

    where:
    FILEPATH                                | status
    new File("")                            | false
//    new File("/home/sumit/demoFileDomain1") | true


    }

}
