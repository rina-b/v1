package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByLawyerId(Long aLong);
}
