<%@page import="java.util.ArrayList"%>
<%@page import="entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>

        Listado de alumnos.<br><br>

        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Semestre</th>
                    <th>Accion</th>
                </tr>
            </thead>
            <tbody>

                <%
                    ArrayList<Student> RESULT = (ArrayList<Student>) session.getAttribute("RESULT");
                    for (Student student : RESULT) {
                %>

                <tr>

                    <td>
                        <%= student.getCode()%>
                    </td>
                    <td>
                        <%= student.getName()%>
                    </td>
                    <td>
                        <%= student.getSemester()%>
                    </td>

                    <td>
                        <a href="PreUpdateStudentServlet?code=<%= student.getCode()%>">Editar</a>
                        <a href="DeleteStudentServlet?code=<%= student.getCode()%>" onclick="return confirm('¿Seguro?')">Eliminar</a>
                    </td>

                </tr>

                <%
                    }
                %>

            </tbody>
        </table>

        <a href="insertStudent.jsp">Agregar</a>

    </body>
</html>
