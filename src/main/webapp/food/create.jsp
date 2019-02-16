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
        Food Create
    </h1>

    <form method="post" action="<%=request.getContextPath()%>/food/create">
        Name:

        <input type="text" name="name"  >
        <br><br>
        Price:
        <input type="number" name="price" >
        <br><br>
        Ingredients:
        <input type="text" name="ingredients"  >
        <br><br>

        <input type="submit" value="Save" >
    </form>

</center>
</body>
</html>