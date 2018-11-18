package com.ttn.linksharing

import com.ttn.linksharing.co.SearchCO
import com.ttn.linksharing.vo.SubscriptionsVO

class User {
    String email
    String password
    String firstName
    String lastName
    byte[] photo
    Boolean active
    Boolean admin
    String confirmPassword
    String fullName
    String userName
    Date dateCreated
    Date lastUpdated


    static hasMany = [topics: Topic, subscriptions: Subscription, readingIteams: ReadingItem, resources: Resource]

    static mapping = {
        photo(sqlType: "longblob")
        sort id: 'desc'
        subscriptions lazy: false
    }

    static constraints = {
        email unique: true, blank: false, nullable: false, email: true
        password size: 5..15, blank: false, nullable: false, bindable:true , validator: {password, obj ->
            obj.confirmPassword == password ? true : ['invalid.matchingpasswords']
        }

        firstName unique: true, blank: false, nullable: false
        lastName(blank: false, nullable: false)
        photo nullable: true
        admin nullable: true
        active nullable: true
//        confirmPassword(size: 5..15, blank: false, nullable: false, bindable: true, validator: { val, obj ->
//            if (obj.hasProperty('id')) {
//                if (val == obj.password) {
//                    return true
//                } else {
//                    return false
//                }
//            }
//        })
    }

    List<Resource> getUnReadResources(SearchCO searchCO, User user) {
        List<ReadingItem> unreaditems = ReadingItem.createCriteria().list(offset: 0, max: 10) {
            eq('isRead', false)
            eq('user', this)
        }
        return unreaditems
    }

    List<Topic> getSubscribedTopic() {
        List<Topic> subscribedTopic = []
        if (this.subscriptions) {
            this.subscriptions.each {
                subscribedTopic.add(it.topic)
            }
        }
        subscribedTopic
    }

    Integer getSubscriptionCount() {
        if (this.subscriptions)
            this.subscriptions.size()
        else
            0
    }


    List<SubscriptionsVO> getUserSubscriptions(){
        if(this.subscriptions){
            List<SubscriptionsVO> subscriptionList =[]
            this.subscriptions.each {
                subscriptionList.add(new SubscriptionsVO(topicName: it.topic.name, ownerFirstName: it.topic.createdBy.firstName,
                resourceCount: it.topic.resources.size(), subscriptionCount: it.topic.subscriptions.size(), topicVisibility: it.topic.visibility,
                subscriptionSeriousness: it.seriousness))
            }
        }
            subscriptionList
    }

    Integer getTopicCount() {
        if (topics)
            this.topics.size()
        else
            0
    }
//
//    List<String> getUserTopics() {
//        List<String> userTopics = []
//        if (this.topics) {
//            this.topics.each {
//                userTopics.add(it.name)
//            }
//        }
//        userTopics
//    }

    List getUserTopics(){
        List topic=Topic.findAllByCreatedBy(this)
        return topic
    }
    def isSubscribed(Long id){
        Topic topic =Topic.findById(id)
        Subscription subscription =Subscription.findByTopic(topic)
        if(subscription){
            log.info("Subscription is found")
            return true
        }else{
            log.info("Subscription not found")
        }
    }
    def canDeleteResource(Long id){
        Resource resource=Resource.get(id)
        if(resource){
            if(resource.delete(flush: true)){
                log.info("resource deleted")
                return true
            }else{
                resource.errors.allErrors.collect {message(code:it).join(",")}
                log.info("UNable To delete")
                return false
            }
        }else{
            log.info("no resource found")
            return false
        }
    }


    static transients = ['userName','fullName', 'getSubscribedTopic()']


    String getFullName(){
        this.fullName = this.firstName + " " +this.lastName
        fullName
    }
    String getUserName(){
        this.userName = this.firstName+this.lastName
        userName
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}