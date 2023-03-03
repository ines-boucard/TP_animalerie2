package com.example.tp_animalerie2.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "Adresse")
public class Adresse {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "street")
    private String street;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @OneToOne
    private PetStore petStore;

    public Adresse(String number, String street, String zipCode, String city, PetStore petStore) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.petStore = petStore;
    }
}
