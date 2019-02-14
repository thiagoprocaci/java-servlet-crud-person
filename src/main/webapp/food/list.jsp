<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Person List
    </h1>

    <table>
     <tr>
        <th>
            Order
        </th>
        <th>
            Name
        </th>
        <th>
            Price
        </th>
        <th>
            Ingredients
        </th>
      </tr>
      <c:forEach var="food" items="${foodList}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/food/order">Order</a>
            </td>
            <td>
                <c:out value="${food.name}" />
            </td>
            <td>
                <c:out value="${food.price}" />
            </td>
            <td>
                <c:out value="${food.ingredients}" />
            </td>
        </tr>
      </c:forEach>
     </table>


</center>
</body>
</html>