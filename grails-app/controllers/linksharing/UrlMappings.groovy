package linksharing

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "/"(controller: "login", action: "index")
//        "500"(view:'/error')
//        "404"(view:'/notFound')
        "404"(controller: 'util',action: 'index')
        "500"(controller: 'util',action:'error')
    }
}
