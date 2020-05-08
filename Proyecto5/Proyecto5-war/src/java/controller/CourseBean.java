/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.CourseFacade;

/**
 *
 * @author Ivan
 */
@ManagedBean
@SessionScoped
public class CourseBean {

    @EJB
    private CourseFacade courseFacade;
    private Course course = new Course();

    /**
     * Creates a new instance of CourseBean
     */
    public CourseBean() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String create() {
        this.courseFacade.create(this.course);
        return "course.xhtml";
    }

    public List<Course> read() {
        return this.courseFacade.findAll();
    }

    public String update(Course course) {
        this.course = course;
        return "course.update.form.xhtml";
    }

    public String update() {
        this.courseFacade.edit(this.course);
        return "course.xhtml";
    }

    public void delete(Course course) {
        this.courseFacade.remove(course);
    }

}
