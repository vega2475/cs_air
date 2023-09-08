package com.cs.air.util;

public class ItemResponseError{
    private String message;

    public ItemResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
