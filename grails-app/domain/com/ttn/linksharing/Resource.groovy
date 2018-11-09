package com.ttn.linksharing

import com.ttn.linksharing.co.ResourceSearchCO
import com.ttn.linksharing.vo.RatingInfoVO


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
    static List getTopPost(){
        def list = ResourceRating.createCriteria().list {
            projections{
                createAlias('resource','r')
                groupProperty('r.id')
                property('r.createdBy')
                property('r.topic')
                count('r.id', 'count')
                property('r.description')
            }
            maxResults(5)
            order('count','desc')
        }
        list
    }

    RatingInfoVO getRatingInfo() {
        RatingInfoVO ratingInfoVO = new RatingInfoVO()
        ratingInfoVO.averageScore = averageScore()
        ratingInfoVO.totalVotes = totalVotes()
        ratingInfoVO.totalScore = totalScore()
        ratingInfoVO
    }

    
}
