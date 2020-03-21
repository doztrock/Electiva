package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import connection.Database;
import configuration.Configuration;
import entity.Student;
import model.StudentService;

@WebServlet(name = "InsertStudentServlet", urlPatterns = {"/InsertStudentServlet"})
public class InsertStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Database database;
        Student student;
        StudentService studentService;

        HttpSession session;
        RequestDispatcher view;

        database = new Database(Configuration.DATABASE_HOST, Configuration.DATABASE_USER, Configuration.DATABASE_PASSWORD, Configuration.DATABASE_NAME);

        if (database.connect()) {

            try {

                int result;

                studentService = new StudentService(database);
                session = request.getSession();

                student = new Student();

                student.setCode(Integer.parseInt((request.getParameter("code") == null) ? "" : request.getParameter("code")));
                student.setName(((request.getParameter("name") == null) ? "" : request.getParameter("name")));
                student.setSemester(Integer.parseInt((request.getParameter("semester") == null) ? "" : request.getParameter("semester")));

                result = studentService.addStudent(student);
                session.setAttribute("RESULT", result);

                view = request.getRequestDispatcher("SelectStudentServlet");
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
