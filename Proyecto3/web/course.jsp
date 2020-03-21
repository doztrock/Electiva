<%@page import="entity.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso</title>
    </head>
    <body>

        Listado de cursos.<br><br>

        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descripcion</th>
                    <th>Programa</th>
                    <th>Profesor</th>
                    <th>Creditos</th>
                </tr>
            </thead>
            <tbody>

                <%
                    ArrayList<Course> RESULT = (ArrayList<Course>) session.getAttribute("RESULT");
                    for (Course course : RESULT) {
                %>

                <tr>

                    <td>
                        <%= course.getCode()%>
                    </td>
                    <td>
                        <%= course.getDescription()%>
                    </td>
                    <td>
                        <%= course.getProgram()%>
                    </td>
                    <td>
                        <%= course.getTeacher()%>
                    </td>
                    <td>
                        <%= course.getCredits()%>
                    </td>

                </tr>

                <%
                    }
                %>

            </tbody>
        </table>

        <a href="insertCourse.jsp">Agregar</a>

    </body>
</html>
