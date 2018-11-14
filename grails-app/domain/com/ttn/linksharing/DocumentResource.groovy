package com.ttn.linksharing

class DocumentResource extends Resource{

    String filePath
    Date dateCreated
    Date lastUpdated
    String fileName
    String contentType

    static transients = ['fileName','contentType']

    static constraints = {

    }

}
