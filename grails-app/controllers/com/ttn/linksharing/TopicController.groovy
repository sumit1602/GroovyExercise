package com.ttn.linksharing

import com.ttn.linksharing.enums.Visibility

class TopicController {

    def index() {}

    def showAction(Integer id) {
        List<Topic> topic = Topic.findAllById(id)
        if (topic) {
            if (Visibility.PUBLIC) {
                render "Success"
            }
            if (Visibility.PRIVATE) {
                User user = session.user
                Integer subscriptionCount = user ? Subscription.countByUser(user) : 0
                if (subscriptionCount) {
                    render "success"
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
}
