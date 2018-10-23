package com.ttn.linksharing

class ReadingItem {
    User user
    Resource resource
    boolean isRead
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user nullable: false
        resource nullable: false, unique: 'user' // user should be unique per resource
        isRead nullable: false
    }
}
