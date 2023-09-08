package com.cs.air.util;

public class PersonResponseError{
    private String message;

    public PersonResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
