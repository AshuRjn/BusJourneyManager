package com.mapping.repository;

import com.mapping.entity.BusStop;
import com.mapping.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}