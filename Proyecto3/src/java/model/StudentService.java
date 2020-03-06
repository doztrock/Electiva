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

        String query;
        ResultSet result;

        try {

            query = String.format("SELECT * FROM alumno");
            result = this.database.retrieve(query);

            while (result.next()) {

                Student student = new Student();

                student.setCode(result.getInt(1));
                student.setName(result.getString(2));
                student.setSemester(result.getInt(3));

                list.add(student);

            }

            return list;

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return list;
    }

    public ArrayList<Student> getStudent(Student information) {

        ArrayList<Student> list = new ArrayList<>();

        String query;
        ResultSet result;

        try {

            query = String.format("SELECT * FROM alumno WHERE alumno.codigo = %d", information.getCode());
            result = this.database.retrieve(query);

            while (result.next()) {

                Student student = new Student();

                student.setCode(result.getInt(1));
                student.setName(result.getString(2));
                student.setSemester(result.getInt(3));

                list.add(student);

            }

            return list;

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
