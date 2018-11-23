package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.enums.Visibility
import com.ttn.linksharing.vo.TopicVO
import grails.converters.JSON

class TopicController {
TopicService topicService;
    def index() {}

    def show(Long id, ResourceSearchCO resourceSearchCO) {
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
//                render "Success (Visibility PUBLIC)"
                TopicVO topicVO = new TopicVO(id: id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy.fullName,
                        subscriptionCount: topic.subscriptions.size(), postCount: topic.resources.size())
                render(view: 'showTopics',  model: [topicVO: topicVO])
            }
            if (topic.visibility == Visibility.PRIVATE) {
                User user = session.user
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                if (subscriptionCount) {
                    render "success (Visibility PRIVATE)"
                } else {
                    redirect(controller: 'login', action: 'index')
                    render flash.error = "Subscription doesn't exist"
                }
            }
        } else {
            redirect(controller: 'login', action: 'index')
            render flash.error = "Topic is not found"
        }
    }

    def delete() {
        Topic topic = Topic.get(params.id)
        if (topic) {

            if (topic.delete(flush: true)) {
//            render "Topic is deleted"
//                flash.message = "Topic is deleted"
                log.info "---------${topic} is deleted--------"
                redirect(controller: 'user', action: 'index')
            }
        } else {
//            render "Topic not found of given id"
            flash.error = "Topic not found of given id"
        }
    }

//    def save() {
//        User user = session.user
//        log.info("Current Logged In User : ${user?.firstName}")
//        if (session.user) {
//            Topic topic = new Topic(name: params.name, visibility: params.visibility, createdBy: user)
//            if (topic.save(flush: true, failOnError: true)) {
//                render "Topic Saved Successfully"
//            }
//        }
//    }
    def save() {
        User user = session.user
        if (session.user) {
            Topic newTopicAdd = new Topic(createdBy: user, name: params.topicName, visibility: params.visibility)
            if (newTopicAdd.save(flush: true)) {
                log.info("Topic saved successfully = ${newTopicAdd}")
                flash.message = "TOPIC SAVED SUCCESSFULLY"
//                session.user.addToTopics(newTopicAdd)
                flash.message = "Topic saved successfully = ${newTopicAdd}"
            } else {
                log.info("ERROR WHILE SAVING ${newTopicAdd} TOPIC")
                newTopicAdd.errors.allErrors.each { println it }
                flash.error = "TOPIC NOT SAVED"
                render "ERROR WHILE SAVING ${newTopicAdd} TOPIC"
            }
        redirect(controller: 'user', action: 'index')
        }
    }
//    def saveChangeVisibility() {
//        User user = session.user
//        Topic topic=Topic.findByCreatedBy(user)
//        if (topic) {
//            topic.visibility=params.visibility
//            if(topic.save(flush: true)){
//                log.info("VISIBILITY CHANGED SUCCESFULLY")
//                redirect(view: 'user/editProfile')
//            }else{
//                log.info("VISIBILITY DOESN'T CHANGED ")
//                redirect(view: 'user/editProfile')
//            }
//        }else{
//            log.info("TOPIC NOT FOUND")
//            redirect(view: 'user/editProfile')
//        }
//    }
    def changeName(){
        Topic topic=Topic.findById(params.id)
        if(topic) {
            topic.name = params.newTopicName
            topic.visibility=params.visibility
            if (topic.save(flush: true)) {
//            render "TOPIC NAME CHANGED FROM${topic.topicName} to ${topic.name}"
                log.info("TOPIC NAME SUCCESSFULLY CHANGED")
                flash.message = "TOPIC NAME CHANGED TO ${topic.name}"
                redirect(controller: 'user',action: 'index')
            } else {
                log.info("ERROR WHILE CHANGING TOPIC NAME")
                topic.errors.allErrors.each { println it }
                flash.error = "ERROR WHILE CHANGING TOPIC NAME"
            }

        }
    }
    def changeVisibility(){
        if(topicService.changeVisibility(params)){
            flash.message ="topic visibility successfully updated"
        }else{
            flash.error ="topic visibility not able to update "
        }
        redirect(controller: 'topic', action: 'save')
    }

//    def saveVisibility(){
//        Topic topic=Topic.get(id)
//        if(topic){
//            if(topic.save(flush: true)){
//                log.info("topic visibility successfully updated")
//                flash.message ="topic visibility successfully updated"
//            }
//        }else{
//            log.info("topic visibility not able to update")
//            flash.error ="topic visibility not able to update "
//        }
//    }


    def invite(String name, String email) {
        Topic topic =Topic.findByName(name)
    }
    def join(Long id){
        User userInvitation = session.user
        User topicInvitation = Topic.read(id)
        Subscription subscription=Subscription.countByTopicAndUser(userInvitation, topicInvitation)
        if(subscription){
            Subscription newSubscription=new Subscription(topic: topicInvitation, user: userInvitation)
            if(newSubscription.save()){
                render([message: "Subscribed"]) as JSON
            }else{
                render([error: "Cound not save subscription"]) as JSON
            }
        }else{
            render([message: "User already Subscribed"]) as JSON
        }
        redirect(controller: 'user', action: 'index')
    }
}
