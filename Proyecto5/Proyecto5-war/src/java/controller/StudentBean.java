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

    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }

    public List<Student> studentList() {
        return studentFacade.findAll();
    }

}
