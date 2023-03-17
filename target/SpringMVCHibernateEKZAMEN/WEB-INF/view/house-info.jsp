<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<body>
<h2>House info</h2>



<form:form action="homePage" modelAttribute="houseDescr">

    <c:url var="infoUserButton" value="ownerInfo">
        <c:param name="houseId" value="${houseDescr.id}"/>   <--внутри ссылка параметр с id-->
    </c:url>

    <form:hidden path="id"/>

    Price ${houseDescr.price}
    <br>
    Description ${houseDescr.description}
    <br>
    Rented ${houseDescr.rented}
    <br>
    Owner ${houseDescr.owner.name}
    <p>
        <input type="button" value="Owner information" onclick="window.location.href='${infoUserButton}'">
    </p>
    <br>
    <br>
    <input type="submit" value="Back">
</form:form>


</body>
</html>