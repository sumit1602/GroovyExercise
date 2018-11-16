package com.ttn.linksharing.vo

import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Visibility
import org.grails.datastore.mapping.query.Query

class TopicVO {
    Integer id
    String name
    Visibility visibility
    Integer count
    String createdBy
    Integer subscriptionCount
    Integer postCount

}

