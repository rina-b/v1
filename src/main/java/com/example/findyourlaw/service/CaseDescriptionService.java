package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.CaseDescription;

public interface CaseDescriptionService {
    CaseDescription createDescription(CaseDescription description);

    CaseDescription updateDescription(CaseDescription description);

    CaseDescription findDescriptionById(Long id);

    CaseDescription findDescriptionByCostumerId(Long id);

    void deleteDescriptionById(Long id);
}
