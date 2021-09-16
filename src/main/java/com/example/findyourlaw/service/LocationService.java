package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Costumer;
import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.entity.Location;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;


public interface LocationService {

    void createLocation(Location location);

    void updateLocation(Location location) throws EntityDoesNotExistException;

    Location findById(Long id) throws EntityDoesNotExistException;

    void deleteById(Long id);

    Location findByLawyer(Lawyer lawyer) throws EntityDoesNotExistException;

    Location findByClient(Costumer client) throws EntityDoesNotExistException;
}
