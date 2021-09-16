package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    Optional<Lawyer> findByEmail(String email);

    @Override
    List<Lawyer> findAll();
}
