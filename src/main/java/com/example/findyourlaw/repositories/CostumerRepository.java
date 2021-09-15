package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
