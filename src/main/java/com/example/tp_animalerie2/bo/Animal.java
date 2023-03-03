package com.example.tp_animalerie2.bo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    public Animal() {
    }

    public Animal(LocalDate birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getCouleur() {
        return couleur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "couleur")
    private String couleur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_Petstore" )
    PetStore petStore;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }

    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }
}
