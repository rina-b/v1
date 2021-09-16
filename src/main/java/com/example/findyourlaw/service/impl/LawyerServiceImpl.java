package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.exeption.UserNotFoundException;
import com.example.findyourlaw.repositories.LawyerRepository;
import com.example.findyourlaw.service.LawyerService;

import java.util.List;

public class LawyerServiceImpl implements LawyerService {
    private final LawyerRepository lawyerRepository;

    public LawyerServiceImpl(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    @Override
    public void createLawyer(Lawyer lawyer) {
        lawyerRepository.save(lawyer);
    }

    @Override
    public void updateLawyer(Lawyer lawyer) throws UserNotFoundException {
        lawyerRepository.findById(lawyer.getId()).orElseThrow(() -> {
            return new UserNotFoundException("User "+ lawyer.getId() + " not found");
        });
        lawyerRepository.save(lawyer);
    }

    @Override
    public Lawyer findByEmail(String email) throws UserNotFoundException {
        Lawyer result = lawyerRepository.findByEmail(email).orElseThrow(() -> {
            return new UserNotFoundException("User "+ email + " not found");
        });
        return result;
    }

    @Override
    public Lawyer findById(Long id) throws UserNotFoundException {
        Lawyer result = lawyerRepository.findById(id).orElseThrow(() -> {
            return new UserNotFoundException("User "+ id + " not found");
        });
        return result;
    }

    @Override
    public void deleteById(Long id) throws UserNotFoundException {
        lawyerRepository.deleteById(id);

    }

    @Override
    public List<Lawyer> findAll() {
        return lawyerRepository.findAll();
    }
}
