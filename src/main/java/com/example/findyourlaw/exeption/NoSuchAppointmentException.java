package com.example.findyourlaw.exeption;

public class NoSuchAppointmentException extends  Exception{
    public NoSuchAppointmentException(String message){
        super(message);
    }
}
