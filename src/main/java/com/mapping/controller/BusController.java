package com.mapping.controller;

import com.mapping.entity.Bus;
import com.mapping.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bus")
@Tag(name = "Bus API", description = "Operations related to Bus")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    // Add bus
    @Operation(
            summary = "Add a new bus",
            description = "Create a new bus entry and save it to the database"
    )
    @PostMapping
    public ResponseEntity<String> addBus(
            @Parameter(description = "Bus object to be added", required = true)
            @RequestBody Bus bus
    ) {
        Bus savedBus = busService.addBus(bus);
        return new ResponseEntity<>
                ("Bus saved with ID: " + savedBus.getId(), HttpStatus.CREATED);
    }
    //Delete Bus
    @Operation(
            summary = "Delete bus By Id",
            description = "Deletes the bus with the specified ID from the database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(
            @PathVariable Long id
    ) {
        boolean isDeleted = busService.deleteBusWithId(id);

        if (isDeleted) {
            return new ResponseEntity<>("Bus with ID: " + id + " has been deleted.", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Bus with ID: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
    // Get all Bus
    @Operation(
            summary = "Get All Bus",
            description = "Retrieve all bus details from the database"
    )
    @GetMapping
    public  ResponseEntity<List<Bus>> getAllBus(){
        List<Bus> allBus = busService.getAllBus();
        return  new ResponseEntity<>(allBus,HttpStatus.OK);
    }
    // Get Bus By id
    @Operation(
            summary = "Get Bus By Id",
            description = "Retrieve bus details from the database By Id"

    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getBusById(@PathVariable Long id) {
        Optional<Bus> busWithId = busService.getBusWithId(id);

        if (busWithId.isPresent()) {
            return new ResponseEntity<>(busWithId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bus with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
    // update the bus
    @Operation(
            summary = "Update Bus By Id",
            description = "Update the details of an existing bus in the database by its ID"
    )
    @PutMapping
    public  ResponseEntity<Bus> updateBus(
            @RequestParam Long id,
            @RequestBody Bus bus
    ){
        Bus updatebus = busService.updatebus(id, bus);
        return  new ResponseEntity<>(updatebus,HttpStatus.OK);
    }

}
