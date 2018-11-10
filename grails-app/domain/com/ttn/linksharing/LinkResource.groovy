package com.ttn.linksharing

class LinkResource extends Resource{

    String url
    Date dateCreated
    Date lastUpdated

    static constraints = {
        filePath url: true
    }

}
