package com.ttn.linksharing

import com.ttn.linksharing.enums.Visibility

class TopicController {

    def index() {}

    def show(Integer id) {
//        List<Topic> topic = Topic.findAllById(id)
//        Topic topic = Topic.get(id)
        Topic topic = Topic.read(id)
        if (topic) {
            if (topic.visibility==Visibility.PUBLIC) {
                render "Success (Visibility PUBLIC)"
            }
            if (topic.visibility==Visibility.PRIVATE) {
                User user = session.user
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                if (subscriptionCount) {
                    render "success (Visibility PRIVATE)"
                } else {
                    redirect(controller: 'login', action: 'index')
                    render flash.error = "Subscription doesn't exist"
                }
            }
        }
        else{
            redirect(controller: 'login', action: 'index')
            render flash.error = "Topic is not found"
        }
    }

    def delete(Long id) {
        Topic topic = Topic.load(id)
        if (topic.id == id) {
            topic.delete(flush: true)
            render "Topic is deleted"
            log.info "---------${topic} is deleted--------"
        } else {
            render "Topic not found of given id"
        }
    }


    def save(){
        User user = session.user
        log.info("Current Logged In User : ${user?.firstName}")
        if(session.user){
            Topic topic=new Topic(name: params.name, visibility: params.visibility, createdBy: user)
            if(topic.save(flush: true,failOnError:true)){
                render "Topic Saved Successfully"
            }
        }
    }
}
