<%@page import="java.util.ArrayList"%>
<%@page import="entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar | Alumno</title>
    </head>
    <body>

        <%
            ArrayList<Student> RESULT = (ArrayList<Student>) session.getAttribute("RESULT");
            Student student = new Student();

            if (RESULT.size() > 0) {
                student = RESULT.get(0);
            }

        %>

        <form action="UpdateStudentServlet" method="get">

            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="code" value="<%= student.getCode()%>" readonly></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="name" value="<%= student.getName()%>"></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semester" value="<%= student.getSemester()%>"></td>
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
