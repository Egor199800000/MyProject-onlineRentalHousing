<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Rented</title>
</head>
<body>

<form:form action="homePage" modelAttribute="rentAHouse">

    <form:hidden path="id"/>
    <br>
    <br>
    <input type="submit" value="Back home page">
</form:form>

</body>
</html>