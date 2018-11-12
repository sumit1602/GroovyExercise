package com.ttn.linksharing

class LinksharingTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = "ls"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def image={

    }
    def markasRead = { attrs, body ->
        if (session.user && attrs.resource) {
            ReadingItem readingItem = ReadingItem.findByUserAndResource(session.user, attrs.resource)
            if (readingItem) {
                if (readingItem.isRead) {
                    body = "<u>Mark As Unread</u>"

                } else {
                    body = "<u>Mark As Read</u>"
                }
            }
        }
    }
    def trendingTopics = {

        out << render(template: '/topic/trendingTopics')
    }

    def topPosts = {
        out << render(template: '/resource/topPosts')
    }
    def canDeleteResource = { attrs, body ->
        if (session.user) {
            User user = session.user
            Long id = attrs.resourceId
            if (user.canDeleteResource(id)) {
                body = "Delete"
                out << g.link(body, controller: "resource", action: "delete")
            }
        }
    }
    def showSubscribe = { attrs, body ->
        User user = session.user
        if (user && attrs.id) {
            if (user.isSubscribed(attrs.id)) {
                Subscription subscription = Subscription.findByUserAndTopic(user, Topic.get(attrs.id))
                body = "<u>Unsubscribe</u>"
                out << g.link([controller: "subscription", action: "delete"], body)
            } else {
                body = "<u>Subscribe</u>"
                out << g.link([controller: "subscription", action: "save"], body)
            }

        }

    }
    def subscriptionCount = { attrs, body ->
        Long userId = attrs.id
        Long topicId = attrs.id
        if (userId) {
            out << Subscription.countByUser(User.load(userId))

        } else if (topicId) {

            out << Subscription.countByTopic(Topic.load(topicId))
        } else {
            out << "error"
        }


    }

    def resourceCount = { attrs, body ->
        Topic topic = Topic.load(attrs.id)
        if (topic) {
            out << Resource.countByTopic(topic)
        } else {
            out << "error"
        }
    }

    def topicCount = { attrs, body ->
        User user = User.load(attrs.id)
        if (user) {
            out << Topic.countByCreatedBy(user)
        }

    }


}
