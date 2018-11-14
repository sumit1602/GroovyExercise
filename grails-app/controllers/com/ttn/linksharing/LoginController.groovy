package com.ttn.linksharing

class LoginController {

    def index() {
        if (session['user']) {
            log.info "REDIRECTING TO USER INDEX"
            forward(controller: 'User', action: 'index')
        } else {
//            List recentShareList = Resource.getRecentShares()
//            List topPostsList = Resource.getTopPost()
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
        User newUser = new User([firstName: params.firstName, lastName: params.lastName, userName: params.userName,
                                 email    : params.email, password: params.password, confirmPassword: params.confirmPassword,
                                 active   : true, photo: params.photo.bytes, admin: false])
        if (newUser.save(flush: true)) {
            session.user = newUser
            log.info("user created: ${newUser}")
            forward(controller: 'User', action: 'index')
            render "User created successfully"
        } else {
            log.info("Error in Creating User: ")
            render "Not able to create user"
        }
    }

    def forgetPasswordView() {
        render view: '/login/forgetPasswordView'
    }

    def forgetPassword() {
        User user = User.findByEmail(params.email)
        if (user) {
            user.password = params.newPassword
            user.confirmPassword = params.confirmNewPassword
            if (user.save(flush: true)) {
                session.user = user
                log.info("PASSWORD HAS SUCCESSFULLY CHANGED")
                forward(controller: 'user', action: 'index')
//            render "PASSWORD HAS SUCCESSFULLY CHANGED, Your new password is ${params.newPassword}"
                flash.message = "PASSWORD HAS SUCCESSFULLY CHANGED, Your new password is ${params.newPassword}"
            }
        } else {
            log.info("User with this Email Doesn't exist")
            render view: forgetPassword()
            flash.error = "User with this Email Doesn't exist"
        }
    }
}
