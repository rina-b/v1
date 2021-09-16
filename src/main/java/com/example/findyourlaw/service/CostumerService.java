package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Costumer;
import com.example.findyourlaw.exeption.UserNotFoundException;

public interface CostumerService {

    void createCostumer(Costumer costumer);

    void updateCostumer(Costumer costumer) throws UserNotFoundException;

    Costumer findByEmail(String email) throws UserNotFoundException;

    Costumer findById(Long Id) throws UserNotFoundException;

    void deleteById(Long Id);
}
