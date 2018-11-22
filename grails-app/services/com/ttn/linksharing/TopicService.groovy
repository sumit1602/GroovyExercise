package com.ttn.linksharing

import grails.gorm.transactions.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }
    def changeVisibility(Map data){
        Topic topic =Topic.findById(data.id)
        topic.visibility = com.ttn.linksharing.enums.Visibility.valueOf(data.visibility)
        if(topic.save(flush: true)){
            log.info ("topic visibility changed: $topic")
            true
        }else{
            log.error ("topic visibility unable to changed: $topic")
            topic.errors.allErrors.each{println it}
            false
        }

    }
}
