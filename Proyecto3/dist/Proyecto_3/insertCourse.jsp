<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear | Curso</title>
    </head>
    <body>

        <form action="InsertCourseServlet" method="get">

            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="description"></td>
                </tr>
                <tr>
                    <td>Programa</td>
                    <td><input type="text" name="program"></td>
                </tr>
                <tr>
                    <td>Profesor</td>
                    <td><input type="text" name="teacher"></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="credits"></td>
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
