package com.ttn.linksharing

class ResourceRating {
    User user
    Resource resource
    int score
    Date dateCreated
    Date lastUpdated

    static constraints = {
        resource unique: 'user'
        resource nullable: false
        score nullable: false, range: 1..5
    }
}
