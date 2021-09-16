package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Costumer;

public interface CostumerService {

    Costumer createCostumer(Costumer costumer);

    Costumer updateCostumer(Costumer costumer);

    Costumer findByEmail(String email);

    Costumer findById(Long Id);

    void deleteById(Long Id);
}
