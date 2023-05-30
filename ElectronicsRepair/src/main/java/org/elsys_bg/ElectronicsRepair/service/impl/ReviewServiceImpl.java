package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.Review;
import org.elsys_bg.ElectronicsRepair.repository.ReviewRepository;
import org.elsys_bg.ElectronicsRepair.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    public final ReviewRepository reviewRepository;

    public Review getById(Long reviewId){
        return reviewRepository.getById(reviewId);
    }

    @Override
    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    @Override
    public Review save(Review review){
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review){
        reviewRepository.delete(review);
    }

    @Override
    public void updateReview(Review review) throws NoSuchElementException {
        Review existingReview = reviewRepository.findById(Long.valueOf(review.getId())).orElse(null);
        if(existingReview != null){
            existingReview.setClient(review.getClient());
            existingReview.setReviewText(review.getReviewText());
            reviewRepository.save(existingReview);
        }else{
            throw new NoSuchElementException("ERR: Review with ID " + review.getId() + " does not exist.");
        }
    }
}