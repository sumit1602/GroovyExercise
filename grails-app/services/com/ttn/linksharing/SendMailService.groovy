package com.ttn.linksharing

import grails.gorm.transactions.Transactional

@Transactional
class SendMailService {

    def mailService
    def serviceMethod() {

    }
    void sendMailMethod(){
        mailService.sendMail {
            to "sumitchaudhary39@gmail.com"
            subject "hi sumit"
            body "-------"
        }
    }
}
