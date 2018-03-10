<%--
  Created by IntelliJ IDEA.
  User: misha
  Date: 10.3.18
  Time: 13.59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>My task</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

        <div class="centred">

            <form action="ParserServlet" method="get">

                <input type="hidden" name="page" value="1">
                <input type="submit" name="parsType" value="SAX">


            </form>
            <form action="ParserServlet" method="get">

                <input type="hidden" name="page" value="1">
                <input type="submit" name="parsType" value="StaX" />


            </form>
            <form action="ParserServlet" method="get">

                <input type="hidden" name="page" value="1">
                <input type="submit" name="parsType" value="DOM">

            </form>

        </div>


    </body>

</html>
