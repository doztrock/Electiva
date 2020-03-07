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

        <br><br> Listado de cursos. <br><br>

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

        <br><br> Agregar curso. <br><br>

        <form action="InsertCourseServlet" method="GET">

            <table border="1">
                <tbody>
                    <tr>
                        <td>Codigo</td><td><input type="text" name="code"></td>
                    </tr>
                    <tr>
                        <td>Descripcion</td><td><input type="text" name="description"></td>
                    </tr>
                    <tr>
                        <td>Programa</td><td><input type="text" name="program"></td>
                    </tr>
                    <tr>
                        <td>Profesor</td><td><input type="text" name="teacher"></td>
                    </tr>
                    <tr>
                        <td>Creditos</td><td><input type="text" name="credits"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="ACTION" value="INSERT">
                            <input type="submit" value="Agregar">
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>

    </body>
</html>
