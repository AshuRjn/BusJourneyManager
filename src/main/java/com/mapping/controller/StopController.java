package com.mapping.controller;

import com.mapping.entity.Stop;
import com.mapping.service.StopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stop")
@Tag(name = "Stop API", description = "Operations related to Bus stops")
public class StopController {

    private StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }
//  ADD Stop
    @Operation(
            summary = "Add a new Stop",
            description = "Create a new Stop entry and save it to the database"
    )
    @PostMapping("/Stops")
    public ResponseEntity<String> addStop(
            @RequestBody Stop stop
    ) {
        Stop savestop = stopService.addStop(stop);
        return new ResponseEntity<>(
                "Bus stop saved with ID: " + savestop.getId(), HttpStatus.CREATED);
    }
//  DELETE Stop
    @Operation(
            summary = "Delete Stop By Id",
            description = "Delete Stop from database By id"
    )
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteStop(
            @PathVariable Long id
    ){

        stopService.deleteStop(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
//  GET ALL Stop
    @Operation(
            summary = " Get All Stops",
            description = "Retrieve all stop records from the database"
    )
    @GetMapping("/Stops")
    public ResponseEntity<List<Stop>> getAllStop(){
        List<Stop> allStop = stopService.getAllStop();
        return new ResponseEntity<>(allStop,HttpStatus.OK);
    }

 // GET Stop By id
    @Operation(
            summary = "Get Stop by ID",
            description = "Retrieve a specific stop by its ID"
    )
    @GetMapping("/stop/{id}")
    public ResponseEntity<?> getStopById(
            @PathVariable Long id
    ){
        Stop stopById = stopService.getStopById(id);
        if (stopById != null){
            return new ResponseEntity<>(stopById,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Stop With Id"+id+"Not Found",HttpStatus.NOT_FOUND);
        }
    }
 // UPDATE STOP
    @Operation(
            summary = "Update Bus Stop By id",
            description = "Update the stop name in the database by ID"
    )
    @PutMapping("/stops/{id}")
    public ResponseEntity<?> updateStop(
           @PathVariable Long id,
           @RequestBody Stop stop
    ){
        Stop savestop = stopService.updateStop(id, stop);
        if (savestop != null){
            return  new ResponseEntity<>(savestop,HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("Stop with Id"+id+"Not found",HttpStatus.NOT_FOUND);
        }
    }
}
