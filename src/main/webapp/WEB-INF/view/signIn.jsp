<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>User info</h2>

<form:form action="authorized" modelAttribute="user">


  <form:hidden path="id"/>
  <br><br>
  Email <form:input path="email"/>
  <form:errors path="email"/>
  <br><br>
  Password <form:input type="text" path="password"/>
  <form:errors path="password"/>
  <br><br>
  <br><br>
  <form:hidden path="name"/>
  <form:hidden path="surname"/>
  <form:hidden path="country"/>
  <form:hidden path="city"/>
  <form:hidden path="dateOfBirth"/>
  <form:hidden path="rating"/>
  <form:hidden path="enable"/>
  <input type="submit" value="Login">

</form:form>

</body>
</html>
