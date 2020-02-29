package modelo;

import conexion.ConexionBD;
import entidad.Alumno;
import java.util.ArrayList;

public class Servicio {

    private ConexionBD conexion;

    public Servicio() {
        conexion = new ConexionBD();
    }

    public int agregarAlumno(Alumno alumno) {

        String cadena = "INSERT INTO alumno VALUES (" + alumno.getCodigo() + " ," + alumno.getNombre() + "," + alumno.getSemestre() + ")";

        return conexion.executeUpdateStatement(cadena);
    }

    public ArrayList<Alumno> listarAlumnos(){
    
    }
    
}
