package com.ttn.linksharing

class UserController {

def assetResourceLocator

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
//            log.info("PHOTO IS UPLOADED")
            photo = user.photo
        }else{
//            log.info("PHOTO NOT FOUND")
            photo = assetResourceLocator.findAssetForURI('image.png').byteArray
        }
        OutputStream outputStream = response.getOutputStream()
        outputStream.write(photo)
        outputStream.flush()
        outputStream.close()
    }
/*    def register(){
        User newUser = new User(firstName: params.firstName, lastName: params.lastName, userName: params.userName,
        email: params.email, password: params.password, confirmPassword: params.confirmPassword,
                active: true, photo: params.photo.bytes)
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
}
