package com.ttn.linksharing

import grails.gorm.services.Service
import grails.transaction.Transactional

@Transactional
class readingItemService{
    def changeIsRead(Map readingItemData){
        String str="UPDATE ReadingItem set isRead=true where id=${readingItemData.id}"
        return ReadingItem.executeUpdate(str)
    }
}