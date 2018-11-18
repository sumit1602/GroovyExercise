package com.ttn.linksharing

import grails.transaction.Transactional


class ReadingItemController {

    def index() {
        render "Reading items Comntroller index"
    }
    def changeIsRead(Long Id, Boolean isRead){
        if (User.executeUpdate("Update reading items r set r.isRead=:isRead where r.id=:Id", [isRead: isRead, Id: Id])) {
            flash.message = "MARKED AS READ"
        }
        else {
            flash.error = "ERROR"
            redirect(controller: 'user', action: 'index')
        }
    }

    @Transactional
    def save(Long id){
        User user = session.user
        Resource resource =Resource.get(id)
        if(session.user){
            ReadingItem readingItem = new ReadingItem(user: user,resource: resource, isRead: params.isRead)
            if(readingItem.save(flush:true)){
                render "READING ITEMS SUCCESSFULLY SAVED"
                log.info("READING ITEMS SUCCESSFULLY SAVED")
            }
        }

    }
}
