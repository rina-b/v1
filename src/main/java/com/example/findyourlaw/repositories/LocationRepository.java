package com.example.findyourlaw.repositories;

import com.example.findyourlaw.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
