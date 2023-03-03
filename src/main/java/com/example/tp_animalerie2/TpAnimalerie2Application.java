package com.example.tp_animalerie2;

import com.example.tp_animalerie2.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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

    Animal animal1 = new Animal(LocalDate.of(2002, 3, 7), "marron");
    Cat cat1 = new Cat(LocalDate.of(2002, 3, 7), "marron", "chilp");
    Fish fish1 = new Fish(LocalDate.of(2002, 3, 7), "marron", FishLivEnv.FRESH_WATER);

    Set<Animal> animaux = new HashSet<>();
        animaux.add(animal1);
        animaux.add(cat1);

    PetStore petStore = new PetStore("Super Petstore", "manager test", animaux);



    em.persist(petStore);
    em.persist(fish1);
    em.persist(cat1);
    em.persist(animal1);


        et.commit();
        em.close();
        emf.close();
    }

}
