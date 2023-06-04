package org.elsys_bg.ElectronicsRepair.mapper.impl;

import org.elsys_bg.ElectronicsRepair.controller.resources.ReviewResource;
import org.elsys_bg.ElectronicsRepair.entity.Review;
import org.elsys_bg.ElectronicsRepair.mapper.ReviewMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapperImpl implements ReviewMapper{
    @Override
    public Review fromReviewResource(ReviewResource reviewResource){
        if(reviewResource == null){
            return null;
        }
        Review review = new Review();
        review.setId(reviewResource.getId());
        review.setClient(reviewResource.getClient());
        review.setReviewText(reviewResource.getReviewText());
        return review;
    }

    @Override
    public ReviewResource toReviewResource(Review review){
        if(review == null){
            return null;
        }
        ReviewResource reviewResource = new ReviewResource();
        reviewResource.setId(review.getId());
        reviewResource.setClient(review.getClient());
        reviewResource.setReviewText(review.getReviewText());
        return reviewResource;
    }

    @Override
    public List<ReviewResource> toReviewResources(List<Review> reviews){
        return reviews.stream()
                .map(this::toReviewResource)
                .collect(Collectors.toList());
    }
}