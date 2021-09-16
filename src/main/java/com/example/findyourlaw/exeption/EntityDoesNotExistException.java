package com.example.findyourlaw.exeption;

public class EntityDoesNotExistException extends Exception{
    public EntityDoesNotExistException (String message) {
        super(message);
    }
}
