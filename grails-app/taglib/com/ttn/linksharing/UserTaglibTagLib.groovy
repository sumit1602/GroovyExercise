//package com.ttn.linksharing
//
//class UserTaglibTagLib {
//    static defaultEncodeAs = [taglib:'html']
//    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
//    static namespace = "user"
//
//    def isAdmin={ attrs , body ->
//        def user = attrs.username
//        if (user == "admin"){
//            out << body()
//        }
//    }
//    def repeat ={attrs, body ->
//        attrs.times.toInteger().times{ it ->
//            out << body(it)
//        }
//    }
//}
