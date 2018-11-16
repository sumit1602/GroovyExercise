package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.vo.RatingInfoVO
import com.ttn.linksharing.vo.RecentShareVO
import com.ttn.linksharing.vo.TopPostVO


abstract class Resource {

    Topic topic
    User createdBy
    String description
    Date dateCreated
    Date lastUpdated
    static transients = ['ratingInfo']
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description(sqlType: "text")
//        description(topicName: Topic.name)
    }
    static constraints = {

    }

    static namedQueries = {
        search { ResourceSearchCO resourceSearchCO ->
            if (resourceSearchCO.topicId) {
                eq('topicId', resourceSearchCO.topicId)
                if (resourceSearchCO.visibility) {
                    eq('visibility', resourceSearchCO.visibility)
                }
            }
        }
    }

    Integer totalVotes() {
        Integer totalVotes = ResourceRating.createCriteria().count() {
            eq('resource', this)
        }
        totalVotes
    }


    Integer averageScore() {
        Integer averageScore = ResourceRating.createCriteria().get() {
            projections {
                avg('score')
            }
            eq('resource', this)
        }
        averageScore
    }

    Integer totalScore() {
        Integer totalScore = ResourceRating.createCriteria().get() {
            projections {
                sum('score')
            }
            eq('resource', this)
        }
        totalScore
    }
    static List<TopPostVO> getTopPost(){
        def list = ResourceRating.createCriteria().list {
            projections{
                createAlias('resource','r')
                groupProperty('r.id')
                property('r.createdBy')
                property('r.topic')
                count('r.id', 'count')
                property('r.description')
            }
            //maxResults(5)
            order('count','desc')
        }
        List <TopPostVO> topPostVOList= []
        list.each {
            topPostVOList.add(new TopPostVO(ownerUserName: it[1].getUserName(), ownerFullName: it[1].getFullName(),
                    topicId: it[2].id, topicName: it[2].name, resourceDescription: it[4], resourceId: it[0]))
        }
        topPostVOList
    }

    RatingInfoVO getRatingInfo() {
        RatingInfoVO ratingInfoVO = new RatingInfoVO()
        ratingInfoVO.averageScore = averageScore()
        ratingInfoVO.totalVotes = totalVotes()
        ratingInfoVO.totalScore = totalScore()
        ratingInfoVO
    }

    def showPost(){

    }
    static List<RecentShareVO> getRecentShares() {

        List<Resource> resourceList = Resource.createCriteria().list {
            order("dateCreated", "desc")
            maxResults(2)
        }
        List<RecentShareVO> recentShareVOList =[]
        resourceList.each{
            recentShareVOList.add(new RecentShareVO(ownerFullName: it.createdBy.getFullName(), ownerUserName: it.createdBy.getUserName(),
            topicId: it.topic.id, topicName: it.topic.name, resourceDescription: it.description, resourceId: it.id, ownerFirstName: it.createdBy.firstName))
        }
        recentShareVOList
    }


    def deleteFile(){

    }

}
