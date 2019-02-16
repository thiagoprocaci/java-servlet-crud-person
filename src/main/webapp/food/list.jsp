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
        Food List
    </h1>

    <table>
     <tr>

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
       <br><br>
       <a href="<%=request.getContextPath()%>/food/order">Order</a>
        <br><br>
              <a href="<%=request.getContextPath()%>/food/create">Add new food</a>

</center>
</body>
</html>