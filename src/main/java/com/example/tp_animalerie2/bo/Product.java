package com.example.tp_animalerie2.bo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Product ")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProdType type;

    @Column(name = "price")
    private Double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "Compo",
            joinColumns = @JoinColumn( name = "ID_PROD", referencedColumnName = "ID" ),
            inverseJoinColumns = @JoinColumn( name = "ID_PETS", referencedColumnName = "ID" ) )
    Set<PetStore>  Petstores;

    public Product(String code, String label, ProdType type, Double price, Set<PetStore> petstores) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        Petstores = petstores;
    }


    public Product(String code, String label, ProdType type, Double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Product() {
    }

    public enum ProdTypeTest {
        CREATED,
        PROCESSING,
        COMPLETED,
        CANCELLED
    }
}
