package com.ttn.linksharing

class LinkResource extends Resource{

    String url
    Date dateCreated
    Date lastUpdated

    static constraints = {
        url url: true
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    def getType() {
        return true
    }

    @Override
    def deleteFile() {
        return null
    }
}
