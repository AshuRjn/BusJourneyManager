package com.mapping.controller;

import com.mapping.entity.Review;
import com.mapping.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1/buses")
@Tag(name = "Review Api", description = "Operations related to adding and retrieving reviews for buses")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Operation(
            summary = "Add a review to a bus",
            description = "Add a new review to the bus identified by its ID."
    )
    @PostMapping("/{busId}/reviews")
    public ResponseEntity<?> addReview(
            @PathVariable Long busId,
            @RequestBody Review review
    ) {
        review.setReviewDate(LocalDate.now()); // Set the current date
        Review savedReview = reviewService.addReview(busId, review);
        if (savedReview != null) {
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Bus with ID " + busId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Get reviews of Bus By Id",
            description = "Retrieve all reviews for the specified bus ID."
    )
    @GetMapping("/{busId}/reviews")
    public ResponseEntity<Object> getReviewsForBus(
            @PathVariable Long busId
    ) {
        List<Review> reviews = reviewService.getReviewsForBus(busId);
        if (!reviews.isEmpty()) {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No reviews found for this bus ");
        }
    }
}
