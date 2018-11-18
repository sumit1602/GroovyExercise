
package com.ttn.linksharing

import com.ttn.linksharing.co.TopicCO
import grails.transaction.Transactional

class LinkResourceController {

    def index(){

    }

//    def save(params){
//        if(params.createdBy == session.user) {
//            Resource linkResource = new LinkResource([createdBy: params.createdBy, description: params.description,
//                                                      topic    : Topic.findByName(params.name), url: params.url])
//            if (linkResource.save(flush: true)) {
//                log.info("\"linkResource saved Successfully\"")
//                render flash.message = "linkResource saved Successfully"
//            } else {
//                log.info("\"error creating linkResource\"")
//                render flash.error = "error creating linkResource"
//            }
//            redirect(controller: 'user', action: 'index')
//        }
//    }
    @Transactional
    def save(TopicCO co){
        User user= session.user
        if(session.user){
            Topic topic = Topic.get(co.id)
            if(topic){
                Resource linkResource = new LinkResource(topic: topic, createdBy: user, description: co.description, url:co.link)
                if(linkResource.save(flush: true)){
                    flash.message ="Link Resouce created"
                    log.info("Link Resouce created")
                    redirect(controller: 'user',action: 'index')
                }else{
                    linkResource.errors.allErrors.each {println it}
                    flash.message ="Link Resouce  not created"
                    redirect(controller: 'user',action: 'index')

                }
            }
        }
        else{
            flash.message = "user is not logged in"
            log.info("user is not logged in")
            redirect(controller: 'login',action: 'index')
        }
    }
}
