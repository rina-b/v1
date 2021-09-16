package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Lawyer;

import java.util.List;

public interface LawyerService {
    Lawyer createLawyer(Lawyer lawyer);

    Lawyer updateLawyer(Lawyer lawyer);

    Lawyer findByEmail(String email);

    Lawyer findById(Long id);

    void deleteById(Long id);

    List<Lawyer> findAll();


}
