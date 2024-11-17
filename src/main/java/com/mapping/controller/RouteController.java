package com.mapping.controller;

import com.mapping.entity.BusStop;
import com.mapping.service.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @Parameter(description = "Order of the bus stop in the route", required = true) @RequestParam Long orderId
    ){
        BusStop busStop = routeService.addRoute(busId, stopId, orderId);
        return new ResponseEntity<>(busStop, HttpStatus.CREATED);
    }
}
