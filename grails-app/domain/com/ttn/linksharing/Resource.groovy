package com.ttn.linksharing

abstract class Resource {

    Topic topic
    User createdBy
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description(sqlType: "text")
//        description(topicName: Topic.name)
    }
    static constraints = {

    }


}

