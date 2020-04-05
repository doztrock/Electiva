package aplicacion;

import java.util.*;
import javax.persistence.*;

import entidades.Alumno;

public class TestEliminarAlumno {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        Alumno alumno;

        entityManagerFactory = Persistence.createEntityManagerFactory("Ejercicio01_JPAPU");
        entityManager = entityManagerFactory.createEntityManager();

        alumno = entityManager.find(Alumno.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(alumno);
        entityManager.getTransaction().commit();

        System.out.println("Registro eliminado");

    }

}
