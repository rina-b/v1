package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.exeption.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LawyerService {
    void createLawyer(Lawyer lawyer);

    void updateLawyer(Lawyer lawyer) throws UserNotFoundException;

    Lawyer findByEmail(String email) throws UserNotFoundException;

    Lawyer findById(Long id) throws UserNotFoundException;

    void deleteById(Long id) throws UserNotFoundException;

    List<Lawyer> findAll();


}
