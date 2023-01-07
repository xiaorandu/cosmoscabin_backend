package com.project.onlinebooking.exception;

public class StayNotExistException extends RuntimeException {
    public StayNotExistException(String message) {
        super(message);
    }
}