<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>User info</h2>

<form:form action="saveNewUser" modelAttribute="user">


    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Country <form:input path="country"/>
    <form:errors path="country"/>
    <br><br>
    City <form:input path="city"/>
    <form:errors path="city"/>
    <br><br>
    Date of Birth <form:input path="dateOfBirth"/>
    <form:errors path="dateOfBirth"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Password <form:input type="text" path="password"/>
    <form:errors path="password"/>
    <br><br>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>