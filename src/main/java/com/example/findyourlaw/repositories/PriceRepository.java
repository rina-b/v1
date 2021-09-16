package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findByLawyerId(Long aLong);
}
