/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

    /**
     * Creates a new instance of CourseBean
     */
    public CourseBean() {
    }

}
