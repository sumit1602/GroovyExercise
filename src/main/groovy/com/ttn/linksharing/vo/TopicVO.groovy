package com.ttn.linksharing.vo

import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Visibility

class TopicVO {
    Integer id
    String name
    Visibility visibility
    Integer count
    User createdBy
}

