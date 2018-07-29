package com.jconnect.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jconnect.entities.Review;

public interface ReviewRepository extends JpaRepository <Review, Long> {
	

}
