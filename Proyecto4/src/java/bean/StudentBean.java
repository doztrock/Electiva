package bean;

import entity.Student;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@RequestScoped
public class StudentBean {

    private Student student = new Student();
    private ArrayList<Student> list = new ArrayList<>();

    public StudentBean() {
        this.read();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public String create() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(this.getStudent());
        entityManager.getTransaction().commit();

        read();

        return "student.xhtml";
    }

    public final void read() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        this.list = new ArrayList<>(entityManager.createNamedQuery("Student.findAll", Student.class).getResultList());

    }

    public String update(Student student) {
        this.setStudent(student);
        return "student.edit.form.xhtml";
    }

    public String update() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.find(Student.class, this.getStudent().getIdentificator());

        entityManager.getTransaction().begin();
        entityManager.merge(this.getStudent());
        entityManager.getTransaction().commit();

        read();

        return "student.xhtml";
    }

    public void delete(Student student) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Student.class, student.getIdentificator()));
        entityManager.getTransaction().commit();

        read();

    }

}
