/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.StudentFacade;

/**
 *
 * @author Ivan
 */
@ManagedBean
@SessionScoped
public class StudentBean {

    @EJB
    private StudentFacade studentFacade;
    private Student student = new Student();

    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String create() {
        this.studentFacade.create(this.student);
        return "student.xhtml";
    }

    public List<Student> read() {
        return this.studentFacade.findAll();
    }

    public String update(Student student) {
        this.student = student;
        return "student.update.form.xhtml";
    }

    public String update() {
        this.studentFacade.edit(this.student);
        return "student.xhtml";
    }

    public void delete(Student student) {
        this.studentFacade.remove(student);
    }

}
