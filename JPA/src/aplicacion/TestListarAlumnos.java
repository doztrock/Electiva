package aplicacion;

import java.util.*;
import javax.persistence.*;

import entidades.Alumno;

public class TestListarAlumnos {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("Ejercicio01_JPAPU");
        entityManager = entityManagerFactory.createEntityManager();

        List<Alumno> lista = entityManager.createNamedQuery("Alumno.findAll", Alumno.class).getResultList();

        lista.forEach((alumno) -> {
            System.out.println(alumno.getCodigo() + " - " + alumno.getNombre() + " - " + alumno.getSemestre());
        });

    }

}
