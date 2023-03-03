package com.example.tp_animalerie2.bo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PetStore")
public class PetStore {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "managerName")
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    Set<Animal> animals;

    {
        animals = new HashSet<>();
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public PetStore(String name, String managerName, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.animals = animals;
    }

    public PetStore() {
    }
}
