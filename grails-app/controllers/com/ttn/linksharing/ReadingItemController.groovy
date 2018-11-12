package com.ttn.linksharing

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReadingItemController {

    def index() {

    }
    def changeIsRead(){
        if (readingItemService.changeIsRead(params))
            flash.message = "MARKED AS READ"
        else
            flash.error = "ERROR"
        redirect(controller: 'user', action: 'index')
    }
}
