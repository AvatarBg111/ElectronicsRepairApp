package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.Review;

import java.util.List;

public interface ReviewService{
    List<Review> findAll();

    Review save(Review review);
}