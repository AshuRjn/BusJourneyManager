package com.mapping.repository;

import com.mapping.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //List<Review> findByBusId(Long busId);
    public List<Review> findByBus_Id(Long busId);

}