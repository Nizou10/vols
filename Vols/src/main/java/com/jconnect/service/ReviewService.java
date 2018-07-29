package com.jconnect.service;

import java.util.List;

import com.jconnect.entities.Review;

public interface ReviewService {
public List<Review> findAll();
public Review save(Review review);
public void deleteReview(Long id);
}
