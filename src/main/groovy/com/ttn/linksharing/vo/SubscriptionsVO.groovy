package com.ttn.linksharing.vo

import com.ttn.linksharing.enums.Seriousness
import com.ttn.linksharing.enums.Visibility

class SubscriptionsVO {
    String topicName
    String ownerFirstName
    Integer resourceCount
    Integer subscriptionCount
    Visibility topicVisibility
    Seriousness subscriptionSeriousness
}
