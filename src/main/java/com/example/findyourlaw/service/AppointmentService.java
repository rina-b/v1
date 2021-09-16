package com.example.findyourlaw.service;

import com.example.findyourlaw.entity.Appointment;
import com.example.findyourlaw.exeption.NoSuchAppointmentException;

public interface AppointmentService {
    void create(Appointment appointment);
    void update(Appointment appointment) throws NoSuchAppointmentException;
    Appointment findById(Long id) throws NoSuchAppointmentException;
    Appointment findByLawyerId(Long id) throws NoSuchAppointmentException;
}
