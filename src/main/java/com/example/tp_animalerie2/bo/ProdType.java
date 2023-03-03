package com.example.tp_animalerie2.bo;

public enum ProdType {
    FOOD("FOOD") , ACCESSORY("ACCESSORY"), CLEANING("CLEANING");
    private String libelle;
    ProdType( String libelle ) {
        this.libelle = libelle;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle( String libelle ) {
        this.libelle = libelle;
    }
}
