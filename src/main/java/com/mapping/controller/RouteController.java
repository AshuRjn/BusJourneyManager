package com.mapping.controller;

import com.mapping.entity.BusStop;
import com.mapping.entity.Review;
import com.mapping.service.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
@Tag(name = "Route API", description = "Operations related to Add bus routes")
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    @Operation(
            summary = "Add a new bus stop to a route",
            description = "Adds a bus stop to the specified route with busId, stopId, and orderId."
    )
    public ResponseEntity<BusStop> addRoute(
            @Parameter(description = "ID of the bus", required = true) @RequestParam Long busId,
            @Parameter(description = "ID of the bus stop", required = true) @RequestParam Long stopId,
            @Parameter(description ="Details of the bus stop", required = true)@RequestBody BusStop busStop
    ){
        BusStop busRoute = routeService.addRoute(busId, stopId, busStop);
        return new ResponseEntity<>(busRoute, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get all bus routes",
            description = "Fetches a list of all bus stops and their associated routes."
    )
    @GetMapping("/route")
    public ResponseEntity<List<BusStop>> listAllSRoute(){
        List<BusStop> allRoute = routeService.getAllRoute();
        return ResponseEntity.ok(allRoute);
    }
    @Operation(
            summary = "Delete a specific route by ID",
            description = "Deletes a route identified by its unique ID. " +
                    "If the route is successfully deleted, a confirmation message is returned."
    )
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteRoute(
            @PathVariable Long id
    ){
        boolean deleted = routeService.deleteRoute(id);
        if (deleted){
            return ResponseEntity.ok("Route with id "+id+" is deleted");
        }else {
            return new ResponseEntity<>("No Route with id "+id+" is present",HttpStatus.NOT_FOUND);
        }
    }
}
