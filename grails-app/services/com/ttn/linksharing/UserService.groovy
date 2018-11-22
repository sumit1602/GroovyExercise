package com.ttn.linksharing

import com.ttn.linksharing.DTO.EmailDTO
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class UserService {


    def emailService
//    def grailsApplication
//
//    def serviceMethod() {
//
//    }
//    def forgetPassword(String recoveryEmail){
//        User user= User.findByEmail(recoveryEmail)
//        if(user && user.active){
//            String newPassword = RandomPasswordGenerator.getRandomPassword()
//            EmailDTO emailDTO = new EmailDTO(to: [recoveryEmail], subject: "Account recovery" ,view: "/email/_password"
//                    ,model: [userName: user.fullName, newPassword: newPassword, serverUrl: grailsApplication.config.grails.serverURL])
//            emailService.sendMail(emailDTO)
//            user.password = newPassword
//            if(user.save(flush: true)){
//                ([message: "Success"]) as JSON
//                return true
//            }else{
//                ([error: "NOT A VALID USER EMAIL"]) as JSON
//                return false
//            }
//        }
//    }
}
