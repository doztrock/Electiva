package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

import connection.Database;
import configuration.Configuration;
import entity.Course;
import model.CourseService;

@WebServlet(name = "PreUpdateCourseServlet", urlPatterns = {"/PreUpdateCourseServlet"})
public class PreUpdateCourseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        Database database;
        Course course;
        CourseService courseService;

        HttpSession session;
        RequestDispatcher view;

        database = new Database(Configuration.DATABASE_HOST, Configuration.DATABASE_USER, Configuration.DATABASE_PASSWORD, Configuration.DATABASE_NAME);

        if (database.connect()) {

            try {

                ArrayList<Course> list;

                courseService = new CourseService(database);
                session = request.getSession();

                course = new Course();

                course.setCode(Integer.parseInt((request.getParameter("code") == null) ? "" : request.getParameter("code")));

                list = courseService.select(course);
                session.setAttribute("RESULT", list);

                view = request.getRequestDispatcher("updateCourse.jsp");
                view.forward(request, response);

            } catch (ServletException | IOException exception) {
                System.err.println(exception.getMessage());
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "";
    }

}
