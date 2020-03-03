package modelo;

import conexion.ConexionBD;
import entidad.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ArrayList<Alumno> listarAlumnos() {

        String cadena = "SELECT * FROM alumno";
        ResultSet result = conexion.executeQueryStatement(cadena);

        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            while (result.next()) {

                int codigo = result.getInt(1);
                String nombre = result.getString(2);
                int semestre = result.getInt(3);
                
                Alumno a = new Alumno(codigo, nombre, semestre);
                lista.add(a);

            }
        } catch (SQLException ex) {
        }

        return lista;
    }

}
