package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import connection.Database;
import configuration.Configuration;
import entity.Course;
import model.CourseService;

@WebServlet(name = "InsertCourseServlet", urlPatterns = {"/InsertCourseServlet"})
public class InsertCourseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Database database;
        Course course;
        CourseService courseService;

        HttpSession session;
        RequestDispatcher view;

        database = new Database(Configuration.DATABASE_HOST, Configuration.DATABASE_USER, Configuration.DATABASE_PASSWORD, Configuration.DATABASE_NAME);

        if (database.connect()) {

            try {

                int result;

                courseService = new CourseService(database);
                session = request.getSession();

                course = new Course();

                course.setCode(Integer.parseInt((request.getParameter("code") == null) ? "" : request.getParameter("code")));
                course.setDescription(((request.getParameter("description") == null) ? "" : request.getParameter("description")));
                course.setProgram(((request.getParameter("program") == null) ? "" : request.getParameter("program")));
                course.setTeacher(((request.getParameter("teacher") == null) ? "" : request.getParameter("teacher")));
                course.setCredits(Integer.parseInt((request.getParameter("credits") == null) ? "" : request.getParameter("credits")));

                result = courseService.addCourse(course);

                session.setAttribute("ACTION", "INSERT");
                session.setAttribute("RESULT", result);

                view = request.getRequestDispatcher("SelectCourseServlet");
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
