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
        Order
    </h1>
    ${msg}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/food/order">
        Food:
      <select name="food">
          <c:forEach var="food" items="${foodList}">
              <option value="${food.name}">${food.name}</option>
          </c:forEach>
      <select>
      <br><br>
      Person:
      <select name="person">
        <c:forEach var="person" items="${personList}">
            <option value="${person.name}">${person.name}</option>
        </c:forEach>
        <select>
        <br><br>
        <input type="submit" value="Save" >
    </form>

</center>
</body>
</html>