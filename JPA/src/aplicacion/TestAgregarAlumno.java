package aplicacion;

import java.util.*;
import javax.persistence.*;

import entidades.Alumno;

public class TestAgregarAlumno {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        Alumno alumno;

        entityManagerFactory = Persistence.createEntityManagerFactory("Ejercicio01_JPAPU");
        entityManager = entityManagerFactory.createEntityManager();
        
        alumno = new Alumno(50, "Mario Perez", 5);
        
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
     
        System.out.println("Registro agregado");
        
    }

}
