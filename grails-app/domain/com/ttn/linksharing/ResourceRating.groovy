package com.ttn.linksharing

class ResourceRating {
    Resource resource
    String createdBy
    int score
    Date dateCreated
    Date lastUpdated

    static constraints = {
        resource nullable: false
        createdBy nullable: false
        score nullable: false, size: 1..5
    }
}
