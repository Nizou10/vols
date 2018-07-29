package com.jconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jconnect.dao.ReviewRepository;
import com.jconnect.entities.Review;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewRepository reviewRep;

	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return reviewRep.findAll();
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return reviewRep.save(review);
	}

	@Override
	public void deleteReview(Long id) {
		reviewRep.delete(reviewRep.findById(id).get());
		
	}



}
