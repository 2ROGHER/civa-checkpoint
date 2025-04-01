package com.example.buses_ms.controllers;

import com.example.buses_ms.domain.Bus;
import com.example.buses_ms.repositories.IBusRepository;
import com.example.buses_ms.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller()
@RequestMapping("/api/v1/")
public class BusController {
    private static final Logger logger = Logger.getLogger(BusController.class.toString());
    @Autowired
    private BusService busService; // We need to use the IBusRepository Bean here

    @PostMapping(path="/bus/create")
    public ResponseEntity<Bus> createBus(Bus b) {
        try {
            // Do a query to database to obtain the necessary buses from the database
            return ResponseEntity.ok(this.busService.create(b));
        } catch (Exception e) {
            logger.warning("Failed to to save the at database: " + e.getMessage());
            throw  new RuntimeException(e.getMessage());
        }
    }
    
    @GetMapping(path = "/bus/harness")
    public @ResponseBody ResponseEntity<Pageable> getAllBusesH(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name,asc") String s
    ) {
        try {
            return ResponseEntity.ok(this.busService.findAllH(page, size, s));
        } catch (Exception e) {
            logger.warning("Failed to get all buses from the database: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(path = "/bus")
    public @ResponseBody ResponseEntity<Page<Bus>> getAllBuses(Pageable p) {
        try {
            return ResponseEntity.ok(this.busService.findAll(p));
        } catch (Exception e) {
            logger.warning("Failed to get all buses from the database: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(path = "/bus/{id}")
    public @ResponseBody ResponseEntity<Bus> getBusById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(this.busService.findOneById(id));
        } catch (Exception e) {
            logger.warning("Error getting bus by ID: " + id + " " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}
