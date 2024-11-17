package com.mapping.service;

import com.mapping.entity.Stop;
import com.mapping.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopService {

    private StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
  // ADD STOP
    public Stop addStop(Stop stop) {

        Stop savestop = stopRepository.save(stop);
        return savestop;
    }
  // DELETE STOP
    public void deleteStop(Long id) {
        if (!stopRepository.existsById(id)) {
            throw new IllegalArgumentException("Stop with ID " + id + " does not exist.");
        }
        stopRepository.deleteById(id);
    }
 // GET All Stop
    public List<Stop> getAllStop() {
        List<Stop> allStop = stopRepository.findAll();
        return allStop;

    }
    public Stop getStopById(Long id) {
//        Optional<Stop> byId = stopRepository.findById(id);
//        if (byId.isPresent()){
//            Stop stop = byId.get();
//            return stop;
//        }else{
//            return null;
//        }
        return stopRepository.findById(id).orElse(null);
    }


    public Stop updateStop(Long id, Stop stop) {
        Optional<Stop> byId = stopRepository.findById(id);
        if (byId.isPresent()){
            Stop stopid = byId.get();
            stopid.setStopname(stop.getStopname());
            return stopRepository.save(stopid);
        }else {
            return null;
        }
    }
}
