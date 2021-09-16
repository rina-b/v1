package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Costumer;
import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByLawyersContains(Lawyer lawyer);
    Optional<Location> findByCostumersContains(Costumer costumer);
}
