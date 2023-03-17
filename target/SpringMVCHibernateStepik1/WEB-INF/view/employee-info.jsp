<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>Employee info</h2>

<form:form action="saveEmployee" modelAttribute="employee">

<%--это скрытая форма с айди для взятия из этого вью информации об айди работника--%>
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>