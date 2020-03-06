<%@page import="java.util.*"%>
<%@page import="entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>

        Listado

        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Semestre</th>
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

                </tr>

                <%
                    }
                %>

            </tbody>
        </table>

    </body>
</html>
