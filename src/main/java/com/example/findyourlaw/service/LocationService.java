package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Location;

public interface LocationService {
    Location createLocation(Location location);

    Location updateLocation(Location location);

    Location findById(Long id);

    void deleteById(Long id);

    Location findByLawyerId(Long lawyerId);

    Location findByClientId(Long clientId);
}
