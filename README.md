# Java Web usando Servlet - CRUD

## Classes

### Person

```
package com.tbp.repository;

public class Person {

    String name;
    Integer age;
    String city;

    public Person(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


```

### PersonRepository

```
package com.tbp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonRepository {

    static Map<String, Person> personMap;

    static {
        Person john = new Person("John", 20, "Rio de Janeiro");
        Person mary = new Person("Mary", 22, "New York");
        Person andrew = new Person("Andrew", 30, "London");

        personMap = new HashMap<String, Person>();
        personMap.put(john.getName(), john);
        personMap.put(mary.getName(), mary);
        personMap.put(andrew.getName(), andrew);
    }

    public List<Person> findAll() {
        List<Person> personList = new ArrayList<Person>();
        personList.addAll(personMap.values());
        return personList;
    }

    public void save(Person person) {
        personMap.put(person.getName(), person);
    }

    public void delete(String name) {
        personMap.remove(name);
    }

    public Person getByName(String name) {
        return personMap.get(name);
    }
}


```

### PersonCreateServlet

```
package com.tbp.servlet;

import com.tbp.repository.Person;
import com.tbp.repository.PersonRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "person-create-servlet",
        urlPatterns = "/person/create"
)
public class PersonCreateServlet extends HttpServlet {

    PersonRepository personRepository;

    public PersonCreateServlet() {
        personRepository = new PersonRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/person/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String city = req.getParameter("city");
        Person person = new Person(name, age, city);
        personRepository.save(person);
        resp.sendRedirect(req.getContextPath() + "/person/list");
    }
}


```

### PersonEditServlet

```
package com.tbp.servlet;

import com.tbp.repository.Person;
import com.tbp.repository.PersonRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "person-edit-servlet",
        urlPatterns = "/person/edit"
)
public class PersonEditServlet extends HttpServlet {

    PersonRepository personRepository;

    public PersonEditServlet() {
        personRepository = new PersonRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Person person = personRepository.getByName(name);
        req.setAttribute("person", person);
        req.getRequestDispatcher("/person/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("typeAction");
        if("edit".equals(action)) {
            save(req, resp);
        } else {
            delete(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/person/list");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String city = req.getParameter("city");
        Person person = personRepository.getByName(name);
        person.setAge(age);
        person.setCity(city);
        personRepository.save(person);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        personRepository.delete(name);
    }

}


```

### PersonListServlet

```
package com.tbp.servlet;

import com.tbp.repository.Person;
import com.tbp.repository.PersonRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "person-list-servlet",
        urlPatterns = "/person/list"
)
public class PersonListServlet extends HttpServlet {

    PersonRepository personRepository;

    public PersonListServlet() {
        personRepository = new PersonRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = personRepository.findAll();
        req.setAttribute("personList", personList);
        req.getRequestDispatcher("/person/list.jsp").forward(req, resp);
    }


}


```

## JSP

### index.jsp

```
<html>
    <head>
        <meta charset="UTF-8">


    </head>
    <body>

      <a href="<%=request.getContextPath()%>/person/list">Person CRUD</a>


      <br>
    </body>
</html>

```

### list.jsp

```
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
            Edit
        </th>
        <th>
            Name
        </th>
        <th>
            Age
        </th>
        <th>
            City
        </th>
      </tr>
      <c:forEach var="person" items="${personList}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/person/edit?name=${person.name}">Edit</a>
            </td>
            <td>
                <c:out value="${person.name}" />
            </td>
            <td>
                <c:out value="${person.age}" />
            </td>
            <td>
                <c:out value="${person.city}" />
            </td>
        </tr>
      </c:forEach>
     </table>


      <a href="<%=request.getContextPath()%>/person/create">Add Person</a>
</center>
</body>
</html>

```

### edit.jsp

```
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>


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

```

### create.jsp

```
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
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

```