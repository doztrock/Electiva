package model;

import java.sql.*;
import java.util.*;

import connection.Database;
import entity.Course;

public class CourseService {

    private final Database database;

    public CourseService(Database database) {
        this.database = database;
    }

    public ArrayList<Course> getCourse() {

        ArrayList<Course> list = new ArrayList<>();

        String query;
        ResultSet result;

        try {

            query = String.format("SELECT * FROM curso");
            result = this.database.retrieve(query);

            while (result.next()) {

                Course course = new Course();

                course.setCode(result.getInt(1));
                course.setDescription(result.getString(2));
                course.setProgram(result.getString(3));
                course.setTeacher(result.getString(4));
                course.setCredits(result.getInt(5));

                list.add(course);

            }

            return list;

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return list;
    }

    public ArrayList<Course> getCourse(Course information) {

        ArrayList<Course> list = new ArrayList<>();

        String query;
        ResultSet result;

        try {

            query = String.format("SELECT * FROM curso WHERE curso.codigo = %d", information.getCode());
            result = this.database.retrieve(query);

            while (result.next()) {

                Course course = new Course();

                course.setCode(result.getInt(1));
                course.setDescription(result.getString(2));
                course.setProgram(result.getString(3));
                course.setTeacher(result.getString(4));
                course.setCredits(result.getInt(5));

                list.add(course);

            }

            return list;

        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

        return list;
    }

    public int addCourse(Course course) {

        String query = String.format("INSERT INTO curso VALUES (%d, '%s', '%s', '%s', %d)", course.getCode(), course.getDescription(), course.getProgram(), course.getTeacher(), course.getCredits());
        Object result = this.database.execute(query);

        return (int) result;
    }
    /*
    public int updateCourse(Course course) {

        String query = String.format("UPDATE curso SET curso.nombre = '%s', curso.semestre = %d WHERE curso.codigo = %d", course.getName(), course.getSemester(), course.getCode());
        Object result = this.database.execute(query);

        return (int) result;
    }

    public int deleteCourse(Course course) {

        String query = String.format("DELETE FROM curso WHERE curso.codigo = %d", course.getCode());
        Object result = this.database.execute(query);

        return (int) result;
    }
     */
}
