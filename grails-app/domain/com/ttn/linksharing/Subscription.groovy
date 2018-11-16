package com.ttn.linksharing

import com.ttn.linksharing.enums.Seriousness

class Subscription {

    Seriousness seriousness
    Topic topic
    User user
    Date dateCreated
    Date lastUpdated

    static Seriousness convertSeriousness(String seriousness) {
        Seriousness.valueOf(seriousness)
    }

//    static belongsTo = [user: User, topic: Topic]

    static constraints = {
        user nullable: false
        topic nullable: false
        user unique: ['topic']
        seriousness nullable: false, default: Seriousness.SERIOUS
    }

    static mapping = {
        topic lazy: false
        user lazy: false
    }
}