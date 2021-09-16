package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Price;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;

public interface PriceService {
    void createPrice(Price price);

    void updatePrice(Price price) throws EntityDoesNotExistException;

    Price findById(Long id) throws EntityDoesNotExistException;

    Price findByLawyerId(Long id) throws EntityDoesNotExistException;

    void deleteById(Long id);
}
