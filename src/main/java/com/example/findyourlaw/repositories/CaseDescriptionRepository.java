package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.CaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaseDescriptionRepository extends JpaRepository<CaseDescription, Long>{
    Optional<CaseDescription> findByCostumerId(Long aLong);
}
