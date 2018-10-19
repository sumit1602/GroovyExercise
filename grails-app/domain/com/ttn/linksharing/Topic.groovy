package com.ttn.linksharing

import com.ttn.linksharing.enums.Visibility


class Topic {
    Visibility visibility
    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    static hasMany = [subscriptions: Subscription, resources: Resource]

    static constraints = {
        name(nullable: false, blank: false, unique: true)
        createdBy nullable: false
        visibility nullable: false
    }
}
