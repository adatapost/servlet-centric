<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Link page</title>
    </head>
    <body>
        <h1>List</h1>
        <form method="post" action="link">
            <input type="text" name="song_link"/>
            <input type="submit"
                   name="cmd"
                   value="Add"/>
        </form>

        <c:if test="${empty songsList}">
            Empty!!!
        </c:if>

        <c:forEach var="link" 
                   items="${songsList}"
                   varStatus="loop" >
            <p>
                <a href="${link}">Link - ${loop.index}</a>
            </p>
        </c:forEach>
    </body>
</html>
