<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../style.css">
</head>
<body>
<center>
    <h1>
        Person Create
    </h1>

    <form method="post" action="<%=request.getContextPath()%>/person/create">
        Name:

        <input type="text" name="name"  >
        <br><br>
        Age:
        <input type="number" name="age" >
        <br><br>
        City:
        <input type="text" name="city"  >
        <br><br>

        <input type="submit" value="Save" />
    </form>

</center>
</body>
</html>