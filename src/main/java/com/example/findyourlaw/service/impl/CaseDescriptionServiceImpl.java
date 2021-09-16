package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.CaseDescription;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;
import com.example.findyourlaw.repositories.CaseDescriptionRepository;
import com.example.findyourlaw.service.CaseDescriptionService;

public class CaseDescriptionServiceImpl implements CaseDescriptionService {
    private final CaseDescriptionRepository caseDescriptionRepository;

    public CaseDescriptionServiceImpl(CaseDescriptionRepository caseDescriptionRepository) {
        this.caseDescriptionRepository = caseDescriptionRepository;
    }

    @Override
    public void createDescription(CaseDescription description) {
        caseDescriptionRepository.save(description);
    }

    @Override
    public void updateDescription(CaseDescription description) throws EntityDoesNotExistException {
        caseDescriptionRepository.findById(description.getId()).orElseThrow(() ->{
            return new EntityDoesNotExistException("Description " + description.getId() + " does not exists");
        });
        caseDescriptionRepository.save(description);
    }

    @Override
    public CaseDescription findDescriptionById(Long id) throws EntityDoesNotExistException {

        CaseDescription result = caseDescriptionRepository.findById(id).orElseThrow(() ->{
            return new EntityDoesNotExistException("Description " + id + " does not exists");
        });
        return result;
    }

    @Override
    public CaseDescription findDescriptionByCostumerId(Long id) throws EntityDoesNotExistException {
        CaseDescription result = caseDescriptionRepository.findByCostumerId(id).orElseThrow(() ->{
            return new EntityDoesNotExistException("Description " + id + " does not exists");
        });
        return result;
    }

    @Override
    public void deleteDescriptionById(Long id) {
        caseDescriptionRepository.deleteById(id);

    }
}
