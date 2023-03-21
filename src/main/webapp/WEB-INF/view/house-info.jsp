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

    Price ${houseDescr.price} per day
    <br>
    Description ${houseDescr.description}
    <br>
    Owner ${houseDescr.owner.name}
    <p>
        <input type="button" value="Owner information" onclick="window.location.href='${infoUserButton}'">
    </p>
    <br>
    <br>

<%--Доработать   логику по аренде дома --%>
    <c:choose>
        <c:when test="${houseDescr.rented==false}">

            <c:url var="rentAHouse" value="rentAHouse">
                <c:param name="houseId" value="${houseDescr.id}"/>   <--внутри ссылка параметр с id  @RequestParam("houseId"),rentAHouse-атрибут,rentAHouse-это урл-->
            </c:url>
            <input type="button" value="Rent a House" onclick="window.location.href='${rentAHouse}'">
            <br/>
        </c:when>
        <c:otherwise>
            The house is rented
            <br/>
        </c:otherwise>
    </c:choose>


    <br>
    <br>
    <input type="submit" value="Back">
</form:form>


</body>
</html>