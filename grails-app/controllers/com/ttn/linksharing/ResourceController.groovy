package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.co.SearchCO
import com.ttn.linksharing.enums.Visibility
import com.ttn.linksharing.vo.RatingInfoVO
import com.ttn.linksharing.vo.TopicVO

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

    def search(ResourceSearchCO resourceSearchCO) {
        if (resourceSearchCO.q) {
            ResourceSearchCO.visibility = Visibility.PUBLIC
        }
    }
    def show(Integer resourceId) {
        Resource resource = Resource.findById(resourceId)
        RatingInfoVO ratingInfoVO = resource.getRatingInfo()
        render "TOTAL_VOTES: ${ratingInfoVO.totalVotes} TOTAL_SCORE: ${ratingInfoVO.totalScore} AVERAGE_SCORE: ${ratingInfoVO.averageScore}"
    }
    def showPost(){

    }
}

