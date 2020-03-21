<%@page import="java.util.ArrayList"%>
<%@page import="entity.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar | Curso</title>
    </head>
    <body>

        <%
            ArrayList<Course> RESULT = (ArrayList<Course>) session.getAttribute("RESULT");
            Course course = new Course();

            if (RESULT.size() > 0) {
                course = RESULT.get(0);
            }

        %>

        <form action="UpdateCourseServlet" method="get">

            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="code" value="<%= course.getCode()%>" readonly></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="description" value="<%= course.getDescription()%>"></td>
                </tr>
                <tr>
                    <td>Programa</td>
                    <td><input type="text" name="program" value="<%= course.getProgram()%>"></td>
                </tr>
                <tr>
                    <td>Profesor</td>
                    <td><input type="text" name="teacher" value="<%= course.getTeacher()%>"></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="credits" value="<%= course.getCredits()%>"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Guardar">
                    </td>
                </tr>
            </table>

        </form>

    </body>
</html>
