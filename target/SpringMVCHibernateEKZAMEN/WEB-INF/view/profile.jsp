<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<body>
<h2>User info</h2>


<form:form action="homePage" modelAttribute="authUser">

    Name ${authUser.name}
    <br>
    Surname ${authUser.surname}
    <br>
    Country ${authUser.country}
    <br>
    City ${authUser.city}
    <br>
    Email ${authUser.email}
    <br>
    Rating ${authUser.rating}
    <br>
<%--    <c:forEach var="house" items="${allHousesOwnedByTheUser}">--%>

<%--        <c:url var="infoHouseButton" value="profile">--%>
<%--            <c:param name="houseId" value="${allHousesOwnedByTheUser.id}"/>   <--внутри ссылка параметр с id-->--%>
<%--        </c:url>--%>

<%--        <p>--%>
<%--            <input type="button" value="Show" onclick="window.location.href='${infoHouseButton}'">--%>
<%--        </p>--%>


<%--    </c:forEach>--%>
    <br>
    <br>
    <input type="submit" value="Back">
</form:form>
<br>
<br>
<form:form action="logOut" modelAttribute="authUser">
    <input type="submit" value="logOut">
</form:form>

</body>
</html>