package com.spring.ecommerce.service;

import com.spring.ecommerce.persistence.dao.EvaluesRepository;
import com.spring.ecommerce.persistence.model.Evalues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluesService implements IEvaluesService {

    @Autowired
    private EvaluesRepository evaluesRepository;

    @Override
    public List<Evalues> getReviews() {
        return evaluesRepository.findAll();
    }

    @Override
    public Optional<Evalues> getReview(Long id) {
        return evaluesRepository.findById(id);
    }

    @Override
    public Evalues addReview(Evalues evalues) {
        return evaluesRepository.save(evalues);
    }

    @Override
    public Evalues updateReview(Evalues evalues) {
        Optional<Evalues> oldReview = evaluesRepository.findById(evalues.getReview_id());
        if (oldReview.isPresent()){
            Evalues saveEvalues = oldReview.get();
            saveEvalues.setProduct(evalues.getProduct());
            return evaluesRepository.save(saveEvalues);
        }
        return evaluesRepository.save(evalues);
    }

    @Override
    public void delete(Long id) {
        evaluesRepository.deleteById(id);
    }
}
