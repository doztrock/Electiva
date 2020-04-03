/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.*;
import java.util.ArrayList;
import entity.*;

/**
 *
 * @author Sena
 */
@ManagedBean
@RequestScoped
public class StudentBean {

    private Student alumno = new Student();
    private static ArrayList<Student> listaStudents = new ArrayList<>();
    
    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }

    public Student getStudent() {
        return alumno;
    }

    public void setStudent(Student alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Student> getListaStudents() {
        return listaStudents;
    }

    public void setListaStudents(ArrayList<Student> listaStudents) {
        StudentBean.listaStudents = listaStudents;
    }

    public String agregarStudent() {
        StudentBean.listaStudents.add(this.alumno);
        return "index";
    }

    public void eliminarStudent(Student a) {
        StudentBean.listaStudents.remove(a);
    }

    public String editarStudent(Student a) {
        this.alumno = a;
        return "editarStudent";
    }

    public String editarStudent() {
        for (int i = 0; i < StudentBean.listaStudents.size(); i++) {
            if (StudentBean.listaStudents.get(i).getCode() == this.alumno.getCode()) {
                StudentBean.listaStudents.set(i, this.alumno);
            }
        }
        return "index";
    }
}
