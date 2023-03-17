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
    Rented House ${authUser.rentedHouse}
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