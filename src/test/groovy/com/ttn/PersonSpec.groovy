package com.ttn

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class PersonSpec extends Specification implements DomainUnitTest<Person>
       {

    @Unroll
    def "validate user contraints for unique email "() {
        when:

        Person user = new Person(name:"neetu")
        Person user1 = new Person(name:"neetu")
        then:
        user.save() instanceOf Person
        user1.save()==null
        user1.hasErrors()
        user1.errors.allErrors.each { println(it) }

    }
}