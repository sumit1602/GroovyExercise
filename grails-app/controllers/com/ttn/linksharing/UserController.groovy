package com.ttn.linksharing


import com.ttn.linksharing.vo.TopicVO

class UserController {

def assetResourceLocator

    def index() {
        if(session.user){
            log.info("--USER INDEX , SESSION USER , --")
//            List<SubscriptionsVO> subscriptionList = session.user.getUserSubscriptions()
//            render(view: 'index' , model:[subscriptionList: subscriptionList])
        }else{
            redirect(controller: 'login' , action: 'index')
        }

    }

    def userList(){

    }
    def showTopics(){
        render view: '/resource/show'
    }
    def editProfile(){
        User user=session.user
        List topics= Topic.findAllByCreatedBy(user)
        List<TopicVO> userTopics=[]
        topics.each {
            userTopics.add(new TopicVO(id: it.id, name: it.name,visibility: it.visibility,
                    createdBy: it.createdBy.firstName,subscriptionCount: it.subscriptions.size(), postCount: it.resources.size()))
        }
        render(view: 'editProfile' ,model: [userTopics: userTopics])
    }


    def showUserList(){
        render view: '/user/userList'
    }
//    def image(){
//        User user = User.findById(params.id)
//        byte[] photo
//        if(user?.photo){
//            log.info("PHOTO IS UPLOADED")
//            photo = user.photo
//        }else{
//            log.info("PHOTO NOT FOUND")
//            photo = assetResourceLocator?.findAssetForURI('image.png')?.bytes
//        }
//        OutputStream outputStream = Response.getOutputStream()
//        outputStream.write(photo)
//        outputStream.flush()
//        outputStream.close()
//    }

        def image(){
        def user = User.findById(params.id)
        byte[] photo
        if(user?.photo){
            log.info("PHOTO IS UPLOADED")
            photo = user.photo
        }else{
            log.info("PHOTO NOT FOUND")
            photo = assetResourceLocator.findAssetForURI('image.png').byteArray
        }
        OutputStream outputStream = response.getOutputStream()
        outputStream.write(photo)
        outputStream.flush()
        outputStream.close()
    }
/*    def register(){
        User newUser = new User([firstName: params.firstName, lastName: params.lastName, userName: params.userName,
        email: params.email, password: params.password, confirmPassword: params.confirmPassword,
                active: true, photo: params.photo.bytes])
        if(newUser.save(flush: true))
        {
            log.info("user created: ${newUser}")
            render  "User created successfully"
            forward(controller: 'User', action: 'index')

        }
        else{
            log.info("Error in Creating User: ")
            forward(controller: 'login', action: 'index')
            render "Not able to create user"
        }
    }*/

    def changePassword() {
//        def email = session.user.email
        User user=User.findByEmail(session.user.email)
        if (user) {
            user.password = params.updatedPassword
            user.confirmPassword = params.updatedConfirmPassword
            if (user.save(flush: true)) {
//                session.user = user
                log.info("PASSWORD HAS SUCCESSFULLY CHANGED")
                forward(controller: 'user', action: 'index')
//                flash.message = "PASSWORD HAS SUCCESSFULLY CHANGED, Your new password is ${params.newPassword}"
            } else {
                log.info("User with this Email Doesn't exist")
                flash.error = "User with this Email Doesn't exist"
            }
        }
    }

    def updateUser(){
        User user=User.findByEmail(session.user.email)
        if(user){
            user.firstName = params.updatedFirstName
            user.lastName = params.updateLastName
            user.userName = params.updatedUserName
            user.photo = params.updatedPhoto.bytes
            if(user.save(flush: true, failOnError: true)){
                log.info("Your profile is updated")
                flash.message = "Your profile is updated"
                forward(controller: 'user', action: 'index')
            }else{
                log.info("Your profile is not updated")
                flash.error= "Your profile is not updated"
            }

        }
    }
}
