package com.example.findyourlaw.service.impl;

import com.example.findyourlaw.entity.Appointment;
import com.example.findyourlaw.exeption.NoSuchAppointmentException;
import com.example.findyourlaw.repositories.AppointmentRepository;
import com.example.findyourlaw.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);

    }

    @Override
    public void update(Appointment appointment) throws NoSuchAppointmentException {
        appointmentRepository.findById(appointment.getId()).orElseThrow(() -> {
            return new NoSuchAppointmentException("Appointment "+ appointment.getId()+ " has never been created");
        });
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findById(Long id) throws NoSuchAppointmentException {
        Appointment result = appointmentRepository.findById(id).orElseThrow(() -> {
            return new NoSuchAppointmentException("Appointment "+ id+ " has never been created");
        });
        return result;
    }

    @Override
    public Appointment findByLawyerId(Long id) throws NoSuchAppointmentException {
        Appointment result = appointmentRepository.findByLawyerId(id).orElseThrow(() -> {
            return new NoSuchAppointmentException("Appointment to lawyer "+ id+ " has never been created");
        });
        return result;
    }
}
