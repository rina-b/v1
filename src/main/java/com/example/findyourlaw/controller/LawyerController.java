package com.example.findyourlaw.controller;

import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.exeption.UserNotFoundException;
import com.example.findyourlaw.service.impl.LawyerServiceImpl;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LawyerController {
    private final LawyerServiceImpl lawyerService;

    public LawyerController(LawyerServiceImpl lawyerService){
        this.lawyerService = lawyerService;
    }

    @GetMapping("/lawyers")
    public ResponseEntity findAll(){
        List<Lawyer> lawyerList = lawyerService.findAll();
        return ResponseEntity.ok(lawyerList);
    }

    @GetMapping("/lawyers/{id}")
    ResponseEntity findById (@PathVariable Long id){
        Lawyer lawyer;
        try {
            lawyer = lawyerService.findById(id);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(EntityModel.of(lawyer), HttpStatus.OK);
    }
}
