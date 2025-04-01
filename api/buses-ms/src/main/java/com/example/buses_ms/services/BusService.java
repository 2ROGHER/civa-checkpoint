package com.example.buses_ms.services;

import com.example.buses_ms.domain.Bus;
import com.example.buses_ms.dto.BusDTO;
import com.example.buses_ms.repositories.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class is responsible for all business logic related to CRUD operations
 */
@Service // Decorated this class as a service
public class BusService {

    private final IBusRepository busRepository;


    public BusService(IBusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus create(Bus b) {
        try {
            // Do a query to database to obtain the necessary buses from the database
            return this.busRepository.save(b);
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }

    // 1. Add custom pagination [hardcoded] Not recommended!
    public Pageable findAllH(int page, int size, String s) {
        try {
            // Do a query to database to obtain the necessary buses from the database
            return PageRequest.of(page, size, Sort.by(s.split(",")));
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }

    public Page<Bus> findAll(Pageable p) {
        try {
            return this.busRepository.findAll(p);
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }

    public Bus findOneById(String id)  {
        return this.busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find bus with id " + id));
    }




}
