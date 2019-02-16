package com.tbp.servlet;

import com.tbp.repository.Food;
import com.tbp.repository.FoodRepository;
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
        name = "order-servlet",
        urlPatterns = "/food/order"
)
public class OrderServlet extends HttpServlet {

    FoodRepository foodRepository = new FoodRepository();
    PersonRepository personRepository = new PersonRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = personRepository.findAll();
        List<Food> foodList = foodRepository.findAll();

        req.setAttribute("foodList", foodList);
        req.setAttribute("personList", personList);


        req.getRequestDispatcher("/food/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodName = req.getParameter("food");
        String personName = req.getParameter("person");
        String msg = "We are cooking your " + foodName + ", " + personName + "!";
        req.setAttribute("msg", msg);

        List<Person> personList = personRepository.findAll();
        List<Food> foodList = foodRepository.findAll();

        req.setAttribute("foodList", foodList);
        req.setAttribute("personList", personList);

        req.getRequestDispatcher("/food/order.jsp").forward(req, resp);
    }
}
