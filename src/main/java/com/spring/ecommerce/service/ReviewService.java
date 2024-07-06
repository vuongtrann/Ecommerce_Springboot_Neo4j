package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.ReviewRepository;
import com.spring.ecommerce.persistence.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReview(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        Optional<Review> oldReview = reviewRepository.findById(review.getReview_id());
        if (oldReview.isPresent()){
            Review saveReview = oldReview.get();
            saveReview.setProduct(review.getProduct());
            reviewRepository.save(saveReview);
        }
//        return reviewRepository.save(something);
    }

    @Override
    public void deleteReview(Long id) {

    }
}
