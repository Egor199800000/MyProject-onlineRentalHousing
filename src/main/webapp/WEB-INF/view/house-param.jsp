<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>House info</h2>

<form:form action="saveNewHouse" modelAttribute="house" method="post">

  <form:hidden path="id"/>
  Address <form:input path="address"/>
  <form:errors path="address"/>
  <br><br>
  Price <form:input path="price"/> per day
  <form:errors path="price"/>
  <br><br>
  Description <form:input path="description"/>
  <form:errors path="description"/>
  <br><br>

  <br><br>
  <br><br>
  <input type="submit" value="Place">

</form:form>

</body>
</html>