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


    @OneToOne
    private Adresse adresse;
    /*public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "Compo",
            joinColumns = @JoinColumn( name = "ID_PETS", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn( name = "ID_PROD", referencedColumnName = "ID" ) )
    Set<Product> products;


    public PetStore(String name, String managerName, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.animals = animals;
    }

    public PetStore(String name, String managerName,Adresse adresse, Set<Product> products) {
        this.name = name;
        this.managerName = managerName;
        this.adresse = adresse;
        this.products = products;
    }

    public PetStore(String name, String managerName, Adresse adresse) {
        this.name = name;
        this.managerName = managerName;
        this.adresse = adresse;
    }

    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", animals=" + animals +
                '}';
    }
}
