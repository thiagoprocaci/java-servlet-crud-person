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
