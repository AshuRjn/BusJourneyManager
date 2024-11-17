package com.mapping.service;

import com.mapping.entity.Bus;
import com.mapping.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    private BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus addBus(Bus bus) {
        Bus save = busRepository.save(bus);
        return save;
    }

    public boolean deleteBusWithId(Long id) {
        if (busRepository.existsById(id)) {
            busRepository.deleteById(id);
            return true;
        }
           return false;
    }

    public List <Bus> getAllBus() {
        List<Bus> allBus = busRepository.findAll();
        return  allBus;
    }

    public Optional<Bus> getBusWithId(Long id) {
        return busRepository.findById(id);
    }

    public Bus updatebus(Long id, Bus bus) {

        Bus busobj = busRepository.findById(id).get();
        busobj.setBusname(bus.getBusname());

         busRepository.save(busobj);
         return  busobj;
    }
}
