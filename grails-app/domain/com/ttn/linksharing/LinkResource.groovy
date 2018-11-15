package com.ttn.linksharing

class LinkResource extends Resource{

    String filePath
    Date dateCreated
    Date lastUpdated

    static constraints = {
        filePath url: true
    }

}
