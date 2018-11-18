package com.ttn.linksharing

import com.ttn.linksharing.co.TopicCO

class DocumentResourceController {


    def index() {

    }

    def save(TopicCO co) {
        User user = session.user
        if (user) {
            Topic topic = Topic.get(co.id)
            Resource documentResource = new DocumentResource(topic: topic, createdBy: user, description: co.description, filePath: co.filepath)
            if (documentResource.save(flush: true)) {
                flash.message = "Document Resource CReated Successfully  ${documentResource}"
                log.info("Document Resource CReated Successfully  ${documentResource}")
                redirect(controller: 'user', action: 'index')
            } else {
                documentResource.errors.allErrors.collect { message(code: it) }.join(",")
                flash.error = "Document resource not created ${documentResource}"
                redirect(controller: 'user', action: 'index')
            }
        } else {
            flash.message = "User is not logged in"
            redirect(controller: 'user', action: 'index')
        }

    }
}
