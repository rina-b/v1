package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.Price;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;
import com.example.findyourlaw.repositories.PriceRepository;
import com.example.findyourlaw.service.PriceService;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void createPrice(Price price) {
        priceRepository.save(price);
    }

    @Override
    public void updatePrice(Price price) throws EntityDoesNotExistException {
        priceRepository.findById(price.getId()).orElseThrow(() ->{
               return new EntityDoesNotExistException("Prise " + price.getId() + " does not exists");
        });
        priceRepository.save(price);
    }

    @Override
    public Price findById(Long id) throws EntityDoesNotExistException {
        Price result = priceRepository.findById(id).orElseThrow(() ->{
            return new EntityDoesNotExistException("Prise " + id + " does not exists");
        });
        return result;
    }

    @Override
    public Price findByLawyerId(Long id) throws EntityDoesNotExistException {
        Price result = priceRepository.findByLawyerId(id).orElseThrow(() ->{
            return new EntityDoesNotExistException("Prise " + id + " does not exists");
        });
        return result;
    }

    @Override
    public void deleteById(Long id) {
        priceRepository.deleteById(id);
    }
}
