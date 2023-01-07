package com.project.onlinebooking.exception;

public class InvalidReservationDateException extends RuntimeException {
    public InvalidReservationDateException(String message) {
        super(message);
    }
}