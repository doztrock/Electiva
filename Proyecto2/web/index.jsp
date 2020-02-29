<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seguimiento Uno</title>
    </head>
    <body>

        <form action="Servlet" method="get">

            <div>
                <label> A </label>
                <input type="text" name="A">
            </div>

            <div>
                <label> B </label>
                <input type="text" name="B">
            </div>

            <div>
                <label> C </label>
                <input type="text" name="C">
            </div>

            <div>
                <input type="submit" value="Calcular">
            </div>

        </form>

        <%

            Object positivo = session.getAttribute("Positivo");
            Object negativo = session.getAttribute("Negativo");

            if (positivo != null && negativo != null) {

                out.print("Resultado positivo (X1):" + (positivo) + "<br>");
                out.print("Resultado negativo (X2):" + (negativo) + "<br>");

            }

        %>

    </body>
</html>
