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


    @Override
    public String toString() {
        return "DocumentResource{" +
                "filePath='" + filePath + '\'' +
                '}';
    }

    @Override
    def deleteFile() {
        String file=this.filePath
        if(new File(file).delete()){
            return true
        }
    }

    @Override
    def getType() {
        return null
    }
}
