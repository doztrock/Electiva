/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entidades.*;
import java.util.ArrayList;

/**
 *
 * @author Sena
 */
@ManagedBean
@RequestScoped
public class AlumnoBean 
{
    private Alumno alumno = new Alumno();
    private static ArrayList <Alumno> listaAlumnos = new ArrayList<>( );
    
    /**
     * Creates a new instance of AlumnoBean
     */
    public AlumnoBean() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        AlumnoBean.listaAlumnos = listaAlumnos;
    }
    
    public String agregarAlumno( ) {
        AlumnoBean.listaAlumnos.add( this.alumno );
        return "index";
    }
    
    public void eliminarAlumno( Alumno a ) {
        AlumnoBean.listaAlumnos.remove( a );
    }
    
    public String editarAlumno( Alumno a ) {
        this.alumno = a;
        return "editarAlumno";
    }
    
    public String editarAlumno( ) 
    {
        for( int i = 0; i < AlumnoBean.listaAlumnos.size(); i++ ) 
        {
            if( AlumnoBean.listaAlumnos.get( i ).getCodigo() == this.alumno.getCodigo() ) 
            {
                AlumnoBean.listaAlumnos.set( i, this.alumno );
            }
        }
        return "index";
    }
}
