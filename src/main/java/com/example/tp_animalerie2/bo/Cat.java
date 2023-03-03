package com.example.tp_animalerie2.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Cat extends Animal{

    private String chilpld;

    public Cat(LocalDate birth, String couleur, String chilpld) {
        super(birth, couleur);
        this.chilpld = chilpld;
    }

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chilpld) {
        super(birth, couleur, petStore);
        this.chilpld = chilpld;
    }

    public Cat(String chilpld) {
        this.chilpld = chilpld;
    }

    public Cat() {
    }
}
