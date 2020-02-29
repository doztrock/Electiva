package entidad;

public class Alumno {

    private int codigo;
    private String nombre;
    private int semestre;

    public Alumno(int codigo, String nombre, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}
