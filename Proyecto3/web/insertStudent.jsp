<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear | Alumno</title>
    </head>
    <body>

        <form action="InsertStudentServlet" method="get">

            <table border="1">
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semester"></td>
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
