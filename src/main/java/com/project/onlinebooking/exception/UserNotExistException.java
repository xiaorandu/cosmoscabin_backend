package com.project.onlinebooking.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String message) {

        super(message);
    }
}

