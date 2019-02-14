<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Order
    </h1>
    ${msg}
    <form method="post" action="<%=request.getContextPath()%>/food/order">
      <select name="food">
          <c:forEach var="food" items="${foodList}">
              <option value="${food.name}">${food.name}</option>
          </c:forEach>
      <select>
      <br><br>
      <select name="person">
        <c:forEach var="person" items="${personList}">
            <option value="${person.name}">${person.name}</option>
        </c:forEach>
        <select>

        <input type="submit" value="Save" >
    </form>

</center>
</body>
</html>