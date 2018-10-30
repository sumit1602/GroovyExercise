package com.ttn.linksharing


class ApplicationInterceptor {

    boolean before() {
        log.info "----------------------------BEFORE--------------------------------------------------------"
        log.info(" ${params}")
        true
    }

    boolean after() {
        log.info "------------------------------------AFTER------------------------------------------------"
        true
    }

    void afterView() {

    }

    ApplicationInterceptor() {
//        match(controller: User)
//        match(controller: "*")
//        match(controller: ~/(User|Login)/)
        match(controller: "*", action: "*")
    }

}
