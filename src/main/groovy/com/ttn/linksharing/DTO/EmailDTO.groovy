package com.ttn.linksharing.DTO


class EmailDTO {
    List<String> to
    String view
    String subject
    Map model
    String content

    static constraints = {
        model (nullable: true)
        to ( nullable: false)
        view ( nullable: false)
        subject ( nullable: false)
        content ( nullable: false)
    }
}

