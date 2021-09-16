package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.CaseDescription;
import com.example.findyourlaw.exeption.EntityDoesNotExistException;

public interface CaseDescriptionService {
    void createDescription(CaseDescription description);

    void updateDescription(CaseDescription description) throws EntityDoesNotExistException;

    CaseDescription findDescriptionById(Long id) throws EntityDoesNotExistException;

    CaseDescription findDescriptionByCostumerId(Long id) throws EntityDoesNotExistException;

    void deleteDescriptionById(Long id);
}
