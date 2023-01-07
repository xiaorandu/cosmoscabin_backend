package com.project.onlinebooking.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
