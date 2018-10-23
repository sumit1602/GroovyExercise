package com.ttn.linksharing

import com.ttn.linksharing.enums.Seriousness


class Subscription {

    Seriousness seriousness
    Topic topic
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user nullable: false
        topic nullable: false
        user unique: ['topic']
        seriousness nullable: false
    }
}