package com.ttn.linksharing

abstract class Resource {

    Topic topic
    String createdBy
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

static mapping = {
    description (sqlType: "text")
}
    static constraints = {

    }


}

