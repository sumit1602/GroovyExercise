package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.enums.Visibility

class TopicController {

    def index() {}

    def show(Long id, ResourceSearchCO resourceSearchCO) {
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                render "Success (Visibility PUBLIC)"
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
            topic.delete(flush: true)
            render "Topic is deleted"
            log.info "---------${topic} is deleted--------"
            redirect(controller: 'user', action: 'index')
        } else {
            render "Topic not found of given id"
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
                flash.message = "SUCCESSFULLY SAVED "
            } else {
                log.info("ERROR WHILE SAVING ${newTopicAdd} TOPIC")
                newTopicAdd.errors.allErrors.each { println it }
                flash.error = "TOPIC NOT SAVED"
                render "ERROR WHILE SAVING ${newTopicAdd} TOPIC"
            }
        redirect(controller: 'user', action: 'index')
        }
    }
}
