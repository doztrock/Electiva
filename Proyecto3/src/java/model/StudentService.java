package model;

import connection.Database;
import entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {

    private final Database database;

    public StudentService(Database database) {
        this.database = database;
    }

    public ArrayList<Student> getStudent() {

        ArrayList<Student> list = new ArrayList<>();

        String query = "SELECT * FROM alumno";
        ResultSet result = (ResultSet) this.database.execute(query);

        try {

            while (result.next()) {

                int code = result.getInt(1);
                String name = result.getString(2);
                int semester = result.getInt(3);

                list.add(new Student(code, name, semester));

            }

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return list;
    }

    public ArrayList<Student> getStudent(Student student) {

        ArrayList<Student> list = new ArrayList<>();

        String query = "SELECT * FROM alumno";
        ResultSet result = (ResultSet) this.database.execute(query);

        try {

            while (result.next()) {

                int code = result.getInt(1);
                String name = result.getString(2);
                int semester = result.getInt(3);

                list.add(new Student(code, name, semester));

            }

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return list;
    }

    public int addStudent(Student student) {

        String query = String.format("INSERT INTO alumno VALUES (%d, '%s', %d)", student.getCode(), student.getName(), student.getSemester());
        Object result = this.database.execute(query);

        return (int) result;
    }

    public int updateStudent(Student student) {

        String query = String.format("UPDATE alumno SET alumno.nombre = '%s', alumno.semestre = %d WHERE alumno.codigo = %d", student.getName(), student.getSemester(), student.getCode());
        Object result = this.database.execute(query);

        return (int) result;
    }

    public int deleteStudent(Student student) {

        String query = String.format("DELETE FROM alumno WHERE alumno.codigo = %d", student.getCode());
        Object result = this.database.execute(query);

        return (int) result;
    }

}
