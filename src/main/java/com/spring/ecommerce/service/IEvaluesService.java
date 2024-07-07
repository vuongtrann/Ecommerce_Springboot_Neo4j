package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.model.Evalues;

import java.util.List;
import java.util.Optional;

public interface IEvaluesService {
    public List<Evalues> getReviews();
    public Optional<Evalues> getReview(Long id);
    public Evalues addReview(Evalues evalues);
    public Evalues updateReview(Evalues evalues);
    public void delete(Long id);

}
