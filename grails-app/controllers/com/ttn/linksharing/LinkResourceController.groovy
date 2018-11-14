package com.ttn.linksharing

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LinkResourceController {

    def index(){

    }
    def save(params){
        if(params.createdBy == session.user) {
            Resource linkResource = new LinkResource([createdBy: params.createdBy, description: params.description,
                                                      topic    : params.topic, url: params.url])
            if (linkResource.save(flush: true)) {
                log.info("\"linkResource saved Successfully\"")
                render flash.message = "linkResource saved Successfully"
            } else {
                log.info("\"error creating linkResource\"")
                render flash.message = "error creating linkResource"
            }
        }
    }
}
