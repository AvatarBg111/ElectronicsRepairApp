package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.Review;
import org.elsys_bg.ElectronicsRepair.repository.ReviewRepository;
import org.elsys_bg.ElectronicsRepair.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    public final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    @Override
    public Review save(Review review){
        return reviewRepository.save(review);
    }
}