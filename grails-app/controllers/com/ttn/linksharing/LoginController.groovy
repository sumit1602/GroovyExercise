package com.ttn.linksharing

class LoginController {

    def index() {
        if (session['user']) {
//            render "SESSION.USER EXISTS"
            forward(controller: 'User', action: 'index')
        } else {
            render "SESSION.USER DOESN'T EXIST"
        }
//        render session['user']
    }


    def loginHandler(String username, String password) {
        User user = User.findByEmailAndPassword(username, password)
        if (user) {
            if (user.active) {
                session.user = user
//                render "User is active"
                redirect(action: 'index')
            } else {
                render flash.error = 'Your account is not active'
            }
        } else {
            render flash.error = 'User not found'
        }
//        render flash.error
    }

    def logout() {
        session.invalidate
        redirect(controller: 'Login', action: 'index')
    }

    def register() {
        User user = new User(params)
        if (user.save()) {
            render "You are successfully registor"
        } else {
            render "${user.errors.allErrors.properties}"
        }

    }
}
