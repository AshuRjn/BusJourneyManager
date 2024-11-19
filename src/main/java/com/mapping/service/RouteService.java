package com.mapping.service;

import com.mapping.entity.Bus;
import com.mapping.entity.BusStop;
import com.mapping.entity.Stop;
import com.mapping.repository.BusRepository;
import com.mapping.repository.BusStopRepository;
import com.mapping.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final BusStopRepository busStopRepository;
    private final StopRepository stopRepository;
    private final BusRepository busRepository;

    @Autowired
    public RouteService(BusStopRepository busStopRepository, StopRepository stopRepository, BusRepository busRepository) {
        this.busStopRepository = busStopRepository;
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
    }

    public BusStop addRoute(Long busId, Long stopId, BusStop busStop) {
        // Fetch the Bus and Stop from repositories
        Optional<Bus> busOpt = busRepository.findById(busId);
        Optional<Stop> stopOpt = stopRepository.findById(stopId);

        if (busOpt.isEmpty() || stopOpt.isEmpty()) {
            throw new IllegalArgumentException("Bus or Stop not found");
        }

        // Set bus and stop entities
        busStop.setBus(busOpt.get());
        busStop.setStop(stopOpt.get());

        // Use the route name provided in the JSON
        String routeName = busStop.getRoute(); // Already set from the JSON input
        if (routeName == null || routeName.isEmpty()) {
            throw new IllegalArgumentException("Route name is required");
        }
        busStop.setRoute(routeName);

        // Save and return the updated BusStop
        return busStopRepository.save(busStop);
    }


    public List<BusStop> getAllRoute() {
        List<BusStop> allRoute = busStopRepository.findAll();
        return allRoute;
    }

    public boolean deleteRoute(Long id) {
        if (busStopRepository.existsById(id)){
            busStopRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
