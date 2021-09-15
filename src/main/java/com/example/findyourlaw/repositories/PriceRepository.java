package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
