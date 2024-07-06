package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {
    public List<Review> getReviews();
    public Optional<Review> getReview(Long id);
    public Review addReview(Review review);
    public Review updateReview(Review review);
    public void deleteReview(Long id);

}
