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
        this.load();
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

    public void load() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        this.list = new ArrayList<>(entityManager.createNamedQuery("Student.findAll", Student.class).getResultList());

    }

}
