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
