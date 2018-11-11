package com.ttn.linksharing

class LoginController {

    def index() {
        if (session['user']) {
//            render "SESSION.USER EXISTS"
            log.info "REDIRECTING TO USER INDEX"
            forward(controller: 'User', action: 'index')
        } else {
//            render "SESSION.USER DOESN'T EXIST"
//            render view: main.gsp
        }
//        render session['user']
    }


    def loginHandler(String username, String password) {
        User user = User.findByEmailAndPassword(username, password)
        if (user) {
            if (user.active) {
                session['user'] = user
                redirect(controller: 'user', action: 'index')
            } else {
                render flash.error = 'Your account is not active'
            }
        } else {
            render flash.error = 'User not found'
            redirect(controller: 'Login', action: 'index')
        }
    }


    def logout() {
        session.invalidate()
        redirect(controller: 'Login', action: 'index')
    }

    def register() {
        User user = new User(params)
        if (user.save()) {
            session.user
            render "You are successfully register"
            forward(controller: 'User', action: 'index')
        } else {
            render "${user.errors.allErrors.properties}"
        }
    }
}
