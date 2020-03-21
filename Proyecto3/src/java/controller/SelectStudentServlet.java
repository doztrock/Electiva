package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import connection.Database;
import configuration.Configuration;
import entity.Student;
import model.StudentService;

@WebServlet(name = "SelectStudentServlet", urlPatterns = {"/SelectStudentServlet"})
public class SelectStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Database database;
        StudentService studentService;

        HttpSession session;
        RequestDispatcher view;

        database = new Database(Configuration.DATABASE_HOST, Configuration.DATABASE_USER, Configuration.DATABASE_PASSWORD, Configuration.DATABASE_NAME);

        if (database.connect()) {

            try {

                ArrayList<Student> list;

                studentService = new StudentService(database);
                session = request.getSession();

                list = studentService.getStudent();
                session.setAttribute("RESULT", list);

                view = request.getRequestDispatcher("student.jsp");
                view.forward(request, response);

            } catch (ServletException | IOException exception) {
                System.err.println(exception.getMessage());
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "";
    }

}
