package com.ttn.linksharing

class UserController {

    def index() {
        if(session.user){
            log.info("--USER INDEX , SESSION USER , --")

        }else{
//            redirect(controller: 'login' , action: 'index')
        }

    }
    def userList(){

    }
    def showTopics(){
        render view: '/resource/show'
    }
    def editProfile(){
        render view: '/user/profile'
    }
    def showUserList(){
        render view: '/user/userList'
    }
}
