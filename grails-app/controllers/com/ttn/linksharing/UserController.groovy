package com.ttn.linksharing

class UserController {

    def index() {
        render "user dashboard"
//        render session user['username']
    }
}
