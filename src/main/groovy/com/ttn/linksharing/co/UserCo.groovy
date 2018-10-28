package com.ttn.linksharing.co

import groovy.beans.Bindable

@Bindable
class UserCo {
    String name
    String email
    String dob

    BookCo bookCo
    List<BookCo> list= []
}
