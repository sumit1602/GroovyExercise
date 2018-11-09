package com.ttn.linksharing

class UserController {

    def index() {
        if(session.user){
            render "user dashboard"

        }
    }
}
