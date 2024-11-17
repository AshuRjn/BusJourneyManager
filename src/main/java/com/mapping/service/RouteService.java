package com.mapping.service;

import com.mapping.entity.Bus;
import com.mapping.entity.BusStop;
import com.mapping.entity.Stop;
import com.mapping.repository.BusRepository;
import com.mapping.repository.BusStopRepository;
import com.mapping.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BusStop addRoute(Long busId, Long stopId, Long orderId) {

        Optional<Bus> busOpt = busRepository.findById(busId);
        Optional<Stop> stopOpt = stopRepository.findById(stopId);

        if (busOpt.isEmpty() || stopOpt.isEmpty()) {
            throw new IllegalArgumentException("Bus or Stop not found");
        }

        BusStop busStop = new BusStop();
        busStop.setBus(busOpt.get());
        busStop.setStop(stopOpt.get());
        busStop.setOrderId(orderId.intValue());

        return busStopRepository.save(busStop);
    }
}
