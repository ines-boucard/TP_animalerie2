package com.example.tp_animalerie2;

import com.example.tp_animalerie2.bo.*;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.example.tp_animalerie2.bo.ProdType.FOOD;

@SpringBootApplication
public class TpAnimalerie2Application {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore") ;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

    //Animal animal1 = new Animal(LocalDate.of(2002, 3, 7), "marron");
        Adresse adresse1 = new Adresse("12","rue de la joie","nYTG2","Nantes");
        Adresse adresse2 = new Adresse("62","rue de la paix","nYTG2","Paris");
        Adresse adresse3 = new Adresse("22","rue des fleurs","nYTG2","Paris");

        Product product = new Product("EGZB2","label2",ProdType.ACCESSORY, 12.999);
        Product product2 = new Product("EGZZEB2","label22", FOOD, 20.999);
        Product product3 = new Product("BJIZZEB2","label32",ProdType.CLEANING, 29.999);

        Set<Product> products = new HashSet<>();
        products.add(product2);
        products.add(product);

        PetStore petStore = new PetStore("Super Petstore", "manager test",adresse1,products);
        PetStore petStore2 = new PetStore("Super Petstore2", "manager test2",adresse2, products);
        PetStore petStore3 = new PetStore("Super Petstore3", "manager test3",adresse3, products);

        Cat cat1 = new Cat(LocalDate.of(2022, 3, 7), "marron",petStore, "chilp");
        Cat cat2 = new Cat(LocalDate.of(2012, 3, 7), "marron",petStore2, "chilp1");
        Cat cat3 = new Cat(LocalDate.of(2002, 3, 7), "marron",petStore3, "chilp2");

        Fish fish1 = new Fish(LocalDate.of(2002, 3, 7), "blanc",petStore, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(LocalDate.of(2022, 3, 7), "blanc",petStore, FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(LocalDate.of(2012, 3, 7), "blanc",petStore, FishLivEnv.FRESH_WATER);



    em.persist(adresse1);
    em.persist(adresse2);
    em.persist(adresse3);
    em.persist(product);
    em.persist(product2);
    em.persist(product3);
    em.persist(petStore2);
    em.persist(petStore);
    em.persist(petStore3);
    em.persist(fish1);
    em.persist(fish2);
    em.persist(fish3);
    em.persist(cat1);
    em.persist(cat2);
    em.persist(cat3);

        // Requete pour affichier tous les animaux d'un petstore. Il faut changer "where petStore='Numero'"
        TypedQuery<Animal> findAllQUery = em.createQuery("from Animal where petStore='2'", Animal.class);
        System.out.println("All animal : " + findAllQUery.getResultList());

        et.commit();
        em.close();
        emf.close();
    }

}
