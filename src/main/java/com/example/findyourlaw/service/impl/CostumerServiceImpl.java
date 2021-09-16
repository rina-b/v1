package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.Costumer;
import com.example.findyourlaw.exeption.UserNotFoundException;
import com.example.findyourlaw.repositories.CostumerRepository;
import com.example.findyourlaw.service.CostumerService;

public class CostumerServiceImpl implements CostumerService {
    private final CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public void createCostumer(Costumer costumer) {
        costumerRepository.save(costumer);
    }

    @Override
    public void updateCostumer(Costumer costumer) throws UserNotFoundException {
        costumerRepository.findById(costumer.getId()).orElseThrow(() -> {
            return new UserNotFoundException("User "+ costumer.getId() + " not found");
        });
        costumerRepository.save(costumer);
    }

    @Override
    public Costumer findByEmail(String email) throws UserNotFoundException {
        Costumer result = costumerRepository.findByEmail(email).orElseThrow(() -> {
            return new UserNotFoundException("User "+ email + " not found");
        });
        return result;
    }

    @Override
    public Costumer findById(Long id) throws UserNotFoundException {
        Costumer result = costumerRepository.findById(id).orElseThrow(() -> {
            return new UserNotFoundException("User "+ id + " not found");
        });
        return result;
    }

    @Override
    public void deleteById(Long id) {
        costumerRepository.deleteById(id);
    }
}
