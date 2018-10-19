package com.ttn

class Person {
    String name

    static constraints = {
        name unique: true
    }
}
