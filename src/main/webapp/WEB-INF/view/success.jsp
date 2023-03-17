<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Success</title>
</head>
<body>

<h1>Success</h1>
<%--Hello ${nameAttribute}--%>

<form:form action="homePage" modelAttribute="user">
    Welcome ${user.name}
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>