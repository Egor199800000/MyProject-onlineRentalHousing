<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>User info</h2>

<form:form action="saveNewUser" modelAttribute="user">


    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Country <form:input path="country"/>
    <br><br>
    City <form:input path="city"/>
    <br><br>
    Date of Birth <form:input path="dateOfBirth"/>
    <br><br>
    Email <form:input path="email"/>
    <br><br>
    Password <form:input type="text" path="password"/>
    <br><br>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>