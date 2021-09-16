package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findByEmail(String email);
}
