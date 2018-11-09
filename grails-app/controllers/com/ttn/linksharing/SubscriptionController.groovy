package com.ttn.linksharing


class SubscriptionController {

    def index() {}

    def save(Long id, String seriousness) {
        Topic topic = Topic.get(id)
        User user = session.user
        if (user) {
////        if (user && topic) {
//            Subscription subscription = Subscription.findByUserAndTopic(user, topic)
            Subscription subscription = new Subscription(user: user, topic: topic, seriousness:Subscription.convertSeriousness(seriousness))
            if (subscription.save(flush: true)) {
//                subscription = new Subscription(user: user, topic: topic, seriousness: Subscription.convertSeriousness(seriousness))
                render "success"
            } else {
                render "${subscription.errors.allErrors}"
            }
        }
        else {
            redirect(controller: "login", action: "index")
        }
    }

    def delete(Long id) {
        Subscription subscription = Subscription.findById(id)
        if (subscription) {
            try {
                subscription.delete(flush: true,failOnError: true)
                render "success"
            } catch (Throwable e) {
                e.printStackTrace()
            }
        } else {
            render "Not Found"
        }
    }


    def update(Long id, String seriousness) {
        Subscription subscription = Subscription.get(id)
        if (subscription) {
            subscription.setSeriousness(Subscription.convertSeriousness(seriousness))
            println ">>>>>>>>>>>>>>>>>${subscription.validate()}"
            if (subscription.save(flush: true)) {
                render "Success"
            } else {
                render "${subscription.errors.allErrors}"
            }

        } else {
            render "Not found"
        }
    }
}
