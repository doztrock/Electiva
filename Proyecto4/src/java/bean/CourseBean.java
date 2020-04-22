package bean;

import entity.Course;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@RequestScoped
public class CourseBean {

    private Course course = new Course();
    private ArrayList<Course> list = new ArrayList<>();

    public CourseBean() {
        this.read();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Course> getList() {
        return list;
    }

    public void setList(ArrayList<Course> list) {
        this.list = list;
    }

    public String create() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(this.getCourse());
        entityManager.getTransaction().commit();

        read();

        return "course.xhtml";
    }

    public final void read() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        this.list = new ArrayList<>(entityManager.createNamedQuery("Course.findAll", Course.class).getResultList());

    }

    public String update(Course course) {
        this.setCourse(course);
        return "course.edit.form.xhtml";
    }

    public String update() {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.find(Course.class, this.getCourse().getIdentificator());

        entityManager.getTransaction().begin();
        entityManager.merge(this.getCourse());
        entityManager.getTransaction().commit();

        read();

        return "course.xhtml";
    }

    public void delete(Course course) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, course.getIdentificator()));
        entityManager.getTransaction().commit();

        read();

    }
}
