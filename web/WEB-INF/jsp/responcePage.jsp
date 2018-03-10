<!doctype html public "-//w3c//dtd html 4.0 transitional//en">

<%@ page contentType="text/html; charset=windows-1251" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="/WEB-INF/tld/pagination.tld" %>

<html>
    <head> 
        <title>My Task 5</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>
        <div>
            <table border ="1">
                   <tr>
                    <td>Author</td>
                    <td>Genre</td>
                    <td>Price</td>
                    <td>Title</td>
                    <td>Date</td>
                    <td>Description</td>               
                </tr>
                <c:forEach var="i" begin="${currentPage}" end="${library.getLength() - 1}" step="1">
                    <tr>
                        <td><c:out value="${library.getBook(i).getAuthor()}"/> </td>
                        <td><c:out value="${library.getBook(i).getGenre()}"/></td>
                        <td><c:out value="${library.getBook(i).getPrice()}"/></td>
                        <td><c:out value="${library.getBook(i).getTitle()}"/></td>
                        <td><c:out value="${library.getBook(i).getDate()}"/></td>
                        <td><c:out value="${library.getBook(i).getDescription()}"/></td>               
                    </tr>                
                </c:forEach>


            </table>
        </div>



        <div class="pagination">
            <p:pagination parsType="${parseType}" currentPage="${page}" maxPage="${pageCount}"/>
        </div>

    </body>
</html>

