package aplicacion;

import java.util.*;
import javax.persistence.*;

import entidades.Alumno;

public class TestEditarAlumno {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;
        Alumno alumno;

        entityManagerFactory = Persistence.createEntityManagerFactory("Ejercicio01_JPAPU");
        entityManager = entityManagerFactory.createEntityManager();

        alumno = entityManager.find(Alumno.class, 50);

        alumno.setNombre("Daniela Mora");
        alumno.setSemestre(7);

        entityManager.getTransaction().begin();
        entityManager.merge(alumno);
        entityManager.getTransaction().commit();

        System.out.println("Registro modificado");

    }

}
