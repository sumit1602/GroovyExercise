package com.ttn.linksharing


class User {
    String email
    String password
    String firstName
    String lastName
    byte[] photo
    Boolean active
    Boolean admin
    String confirmPassword
    Date dateCreated
    Date lastUpdated


    static hasMany = [topics: Topic, subscriptions: Subscription, readingIteams: ReadingItem, resources: Resource]

    static mapping = {
        photo(sqlType: "longblob")
        [sort: 'id', order: 'desc']
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
    static transients = ['confirmPassword','fullName']


    String getfullName(){
        ['firstName','lastName'].findAll{it}.join(' ')
    }
}


//    @Override
//    public String toString() {
//        return "User{" +
//                "userName='" + ${email} + '\'' +
//                '}';
//    }

