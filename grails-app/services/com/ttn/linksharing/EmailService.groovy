package com.ttn.linksharing

import com.ttn.linksharing.DTO.EmailDTO
import grails.gorm.transactions.Transactional

@Transactional
class EmailService {
    def mailService

    def serviceMethod() {

    }

    def sendMail(EmailDTO emailDTO){

        mailService.sendMail{
            from "sumitchaudhary39@gmail.com"
            to emailDTO.to.toArray()
            println emailDTO.to.toArray()
            subject emailDTO.subject
            if(emailDTO.content){
                body emailDTO.content
                log.info("content is available")
            }else{
                body(view:emailDTO.view,model:emailDTO.model)
                log.info("content is not available")
            }
        }
    }
}
