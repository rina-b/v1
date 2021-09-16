package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Price;

public interface PriceService {
    Price createPrice(Price price);

    Price updatePrice(Price price);

    Price findById(Long id);

    Price findByLawyerId(Long id);

    void deleteById(Long id);
}
