package com.ttn.linksharing

import com.ttn.linksharing.enums.Seriousness
import com.ttn.linksharing.enums.Visibility


class Topic {
    Visibility visibility
    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    static hasMany = [subscriptions: Subscription, resources: Resource]

    static mapping = {
//        sort name:'asc'
        [sort: 'name', order: 'asc']
    }

    def afterInsert() {
        withNewSession { session ->
            Subscription subscription = new Subscription(seriousness: Seriousness.VERY_SERIOUS, user: createdBy, topic: this)
            if(subscription.save(flush: true, failOnError: true)) {
                log.info "Topic ${subscription} is subscribed to the topic creater"
            }
            else{
                log.info "${subscription.errors.allErrors}"
            }
        }
    }
    static constraints = {
        name(nullable: false, blank: false, unique: 'createdBy')
        createdBy nullable: false
        visibility nullable: false
    }



    @Override
    public String toString() {
        return "Topic{" +
                "TopicName='" + name + '\'' +
                '}';
    }
}
