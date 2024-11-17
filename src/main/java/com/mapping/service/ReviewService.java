package com.mapping.service;

import com.mapping.entity.Bus;
import com.mapping.entity.Review;
import com.mapping.repository.BusRepository;
import com.mapping.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BusRepository busRepository;

    // Add Review
    public Review addReview(Long busId, Review review) {
        Optional<Bus> busOptional = busRepository.findById(busId);
        if (busOptional.isPresent()) {
            Bus bus = busOptional.get();

            // Set the Bus object in Review
            review.setBus(bus);

            review.setReviewDate(LocalDate.now());
            return reviewRepository.save(review);
        }
        return null;
    }

    // Get Reviews for a Bus
    public List<Review> getReviewsForBus(Long busId) {
        if (busRepository.existsById(busId)) {
            return reviewRepository.findByBus_Id(busId);
        }
        return new ArrayList<>();  // Return an empty list if the bus is not found
    }
}
