<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <c:forEach var="house" items="${allHouses}">

        <c:url var="infoHouseButton" value="showDetails">
            <c:param name="houseId" value="${house.id}"/>   <--внутри ссылка параметр с id-->
        </c:url>


        <p>Price: ${house.price}</p>
        <p>Address: ${house.address}</p>
        <p>
            <input type="button" value="Show" onclick="window.location.href='${infoHouseButton}'">
        </p>


    </c:forEach>
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