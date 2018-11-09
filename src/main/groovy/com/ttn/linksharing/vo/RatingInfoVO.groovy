package com.ttn.linksharing.vo

import org.omg.PortableInterceptor.INACTIVE

class RatingInfoVO {
    Integer totalVotes
    Integer averageScore
    Integer totalScore

    @Override
    String toString() {
        return "RatingInfoVO{" +
                "totalVotes=" + ${totalVotes} +
                ", averageScore=" + ${averageScore} +
                ", totalScore=" + ${totalScore} +
                '}';
    }
}
