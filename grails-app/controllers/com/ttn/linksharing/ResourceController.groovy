
package com.ttn.linksharing

class ResourceController {

    def index() {}

    def delete(Long id) {
        Resource resource = Resource.load(id)
        if (resource.id == id)
            try {
                resource.delete()
                render "Resource with id ${id} has been deleted"
            } catch (Throwable e) {
                e.printStackTrace()
            }
        else {
            render "No object with given id is Found"
        }
    }
}

