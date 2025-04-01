package com.example.buses_ms.repositories;

import com.example.buses_ms.domain.Bus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IBusRepository extends PagingAndSortingRepository<Bus, String>, CrudRepository<Bus, String>, JpaRepository<Bus, String>{
    // 1. Get all buses by the database implementing pagination
    // List<Bus> findAll(int page, int size);
    // Page<Bus> findAll(Pageable p);

    // 2. Get a bus by ID
    /// Bus findOneById(String id);

    // 3. Remove a bus by ID
    // Bus removeById(String id);

    // 4. Update a bus by ID
    // Bus updateById(String id);

    // 5. Create a new bus
    // Bus createBus(Bus b);



}
