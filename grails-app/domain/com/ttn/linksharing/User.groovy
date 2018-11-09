package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO
import sun.rmi.log.LogInputStream


class User {
    String email
    String password
    String firstName
    String lastName
    byte[] photo
    Boolean active
    Boolean admin
    String confirmPassword
    String fullName
//    String userName
    Date dateCreated
    Date lastUpdated


    static hasMany = [topics: Topic, subscriptions: Subscription, readingIteams: ReadingItem, resources: Resource]

    static mapping = {
        photo(sqlType: "longblob")
        sort id: 'desc'
    }

    static constraints = {
        email unique: true, blank: false, nullable: false
        password(size: 5..15, blank: false, nullable: false)
        firstName unique: true, blank: false, nullable: false
        lastName(blank: false, nullable: false)
        photo nullable: true
        admin nullable: true
        active nullable: true

        confirmPassword(size: 5..15, blank: false, nullable: false, bindable: true, validator: { val, obj ->
            if (obj.hasProperty('id')) {
                if (val == obj.password) {
                    return true
                } else {
                    return false
                }
            }
        })
    }

    List<Resource> getUnReadResources(SearchCO searchCO){
        List<ReadingItem> unreaditems = ReadingItem.createCriteria().list(offset: 0, max:10) {
            eq('isRead', false)
            eq('user',this)
        }
        return unreaditems
    }

    static transients = ['confirmPassword', 'fullName']


    String getfullName() {
        [$ { firstName }, $ { lastName }].findAll { it }.join(' ')
    }


    @Override
    public String toString() {
        return "User{" +
                "FullName='" + $ { fullName } + '\'' +
                '}';
    }

}



