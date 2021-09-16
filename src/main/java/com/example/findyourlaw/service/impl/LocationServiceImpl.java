package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.Costumer;
import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.entity.Location;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;
import com.example.findyourlaw.repositories.LocationRepository;
import com.example.findyourlaw.service.LocationService;

public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) throws EntityDoesNotExistException {
        locationRepository.findById(location.getId()).orElseThrow(() ->{
            return new EntityDoesNotExistException("Location " + location.getId() + " does not exists");
        });
        locationRepository.save(location);
    }

    @Override
    public Location findById(Long id) throws EntityDoesNotExistException {
        Location result = locationRepository.findById(id).orElseThrow(() ->{
            return new EntityDoesNotExistException("Location " + id + " does not exists");
        });
        return result;
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Location findByLawyer(Lawyer lawyer) throws EntityDoesNotExistException {
        Location result = locationRepository.findByLawyersContains(lawyer).orElseThrow(() ->{
            return new EntityDoesNotExistException("Location " + lawyer.getId() + " does not exists");
        });
        return result;
    }

    @Override
    public Location findByClient(Costumer costumer) throws EntityDoesNotExistException {
        Location result = locationRepository.findByCostumersContains(costumer).orElseThrow(() ->{
            return new EntityDoesNotExistException("Location " + costumer.getId() + " does not exists");
        });
        return result;
    }
}
