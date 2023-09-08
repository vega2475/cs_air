package com.cs.air.dto;

import com.cs.air.models.Person;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ItemDTO {
    @NotEmpty
    private String name;

    @NotEmpty
    private String rarity;

    @NotNull
    private Person owner;

    public ItemDTO(String name, String rarity, Person owner) {
        this.name = name;
        this.rarity = rarity;
        this.owner = owner;
    }

    public ItemDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
