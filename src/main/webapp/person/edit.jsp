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
        Person Edit
    </h1>

    <form method="post" action="<%=request.getContextPath()%>/person/edit">
        Name:
        <c:out value="${person.name}" />
        <input type="hidden" name="name" value="${person.name}" >
        <br><br>
        Age:
        <input type="number" name="age" value="${person.age}" >
        <br><br>
        City:
        <input type="text" name="city" value="${person.city}" >
        <br><br>
        <input type="hidden" name="typeAction" value="edit" >
        <input type="submit" value="Save" />
    </form>

    <br><br>

    <form method="post" action="<%=request.getContextPath()%>/person/edit">
      <input type="hidden" name="name" value="${person.name}" >
      <input type="hidden" name="typeAction" value="delete" >
      <input type="submit" value="Delete" />
    </form>

</center>
</body>
</html>