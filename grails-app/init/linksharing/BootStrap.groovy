package linksharing

import com.ttn.linksharing.Constant
import com.ttn.linksharing.DocumentResource
import com.ttn.linksharing.LinkResource
import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import com.ttn.linksharing.enums.Seriousness
import com.ttn.linksharing.enums.Visibility

class BootStrap {

    def init = { servletContext ->
        List<User> users = createUsers()
        List<Topic> topics = createTopics(users)
        List<Resource> resourceList = createResource(topics)
        List<Subscription> subscriptionList = subscribeTopics(users)
        List<ReadingItem> readingItemList = createReadingItems(resourceList)
        List<ResourceRating> resourceRatingList = createResourceRatings(resourceList)
    }

    List<User> createUsers() {
        List<User> users = []
        if (User.count() == 0) {
            User admin = User.findOrSaveWhere(firstName: "sumit", lastName: "chaudhary", email: "sumit.chaudhary@tothenew.com",
                    password: Constant.password, confirmPassword: Constant.password, admin: true, active: true)
            if (admin.save( flush: true)) {
                users.add(admin)
                log.info "Admin ${admin} saved successfully"
            } else {
                log.error "Error saving Admin: ${admin.errors.allErrors}"
            }

            (1..2).each {
                User user = new User(firstName: "sumit${it}", lastName: "chaudhary", email: "sumit${it}.chaudhary@tothenew.com",
                        password: Constant.password, confirmPassword: Constant.password, admin: false, active: true)
                if (user.save( flush: true)) {
                    users.add(user)
                    log.info "User ${user} saved successfully"
                } else {
                    log.error "Error saving user: ${user.errors.allErrors}"
                }
            }
        }
        users
    }

    List<Topic> createTopics(List<User> users) {
        List topics = []
        if (Topic.count() == 0) {
            users.each { User user ->
                (1..5).each {
                    Topic topic = new Topic(name: "Grails${it}", visibility: Visibility.PUBLIC, createdBy: user)
                    if (topic.save(flush: true)) {
                        topics.add(topic)
                        log.info "TOPICS ${it} ADDED SUCCESFULLY"
                    } else {
                        log.info "Error in topic saving $topic.errors.allErrors"
                    }

                }
            }
        }
        topics
    }

    List<Resource> createResource(List<Topic> topics) {
        List<Resource> resourceList = []
        if (resourceList.isEmpty()) {
            println("--RESOURCELIST IS NULL,WE CAN PUT LINK AND DOCUMENT RESOURCE THERE--")
            topics.each { Topic topic ->
                2.times {
                    LinkResource linkResource = new LinkResource(url: "http://www.tothenew.com/", createdBy: topic.createdBy, description: topic.name, topic: topic)
                    if (linkResource.save(flush: true, failOnError: true)) {
                        resourceList.add(linkResource)
                        log.info("LinkResource ${linkResource} saved succesfully")
                    } else {
                        log.info "document resource doesn't saved successfully ${linkResource.errors.allErrors}"
                    }
                }
                2.times {
                    DocumentResource documentResource = new DocumentResource(filePath: "/home/sumit/Desktop/tocopy.file3", createdBy: topic.createdBy, description: topic.name, topic: topic)
                    if (documentResource.save(flush: true)) {
                        resourceList.add(documentResource)
                        log.info("DocumentResource ${it} saved succesfully")
                    } else {
                        log.info "document resource doesn't saved successfully ${documentResource.errors.allErrors}"
                    }
                }
            }
        }
        resourceList
    }

    List<Subscription> subscribeTopics(List<User> users) {
        List<Subscription> subscriptionList = []
        users.each { User user ->
            Topic.findAllByCreatedByNotEqual(user).each { Topic topic ->
                Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.CASUAL)
                if (subscription.save(failOnError: true, flush: true)) {
                    subscriptionList.add(subscription)
                    log.info("Subscription ${Subscription} save succesfully")
                } else {
                    log.info("Subscription has error  ${Subscription.errors.allErrors}")
                }
            }
        }
        subscriptionList
    }

    List<ReadingItem> createReadingItems(List<Resource> resourceList) {
        List<ReadingItem> readingItemList = []
        resourceList.each { Resource resource ->
            ReadingItem readingItem = new ReadingItem(user: resource.createdBy, isRead: true, resource: resource)
            if (readingItem.save(flush: true, failOnError: true)) {
                readingItemList.add(readingItem)
                log.info "READINGITEAMS READ SUCCESSFULLY ${readingItem}"
            } else {
                log.info "ERROR HAS OCCURED WHILE READING ITEMS ${readingItem}"
            }
        }
        readingItemList
    }


    List<ResourceRating> createResourceRatings(List<Resource> resourceList) {
        List resourceRatingList = []
        resourceList.each { Resource resource ->
            ResourceRating resourceRating = new ResourceRating(user: resource.createdBy, resource: resource, score: 4)
            if (resourceRating.save(failOnError: true, flush: true)) {
                resourceRatingList.add(resourceRating)
                log.info("ResourceRating ${ResourceRating} done")
            } else {
                log.info("ResourceRating not done ${ResourceRating.errors.allErrors}")
            }
        }
        resourceRatingList
    }

    def destroy = {
    }
}
