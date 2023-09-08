package com.cs.air.dto;

import com.cs.air.models.Item;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PersonDTO {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Incorrect name")
    private String username;

    @NotEmpty
    private String password;

    private List<Item> items;

    public PersonDTO(String username, String password, List<Item> items) {
        this.username = username;
        this.password = password;
        this.items = items;
    }

    public PersonDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
