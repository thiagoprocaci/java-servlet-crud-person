package com.tbp.servlet;


import com.tbp.repository.Food;
import com.tbp.repository.FoodRepository;
import com.tbp.repository.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "food-list-servlet",
        urlPatterns = "/food/list"
)
public class FoodListServlet extends HttpServlet {

    FoodRepository foodRepository = new FoodRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foodList = foodRepository.findAll();
        req.setAttribute("foodList", foodList);
        req.getRequestDispatcher("/food/list.jsp").forward(req, resp);
    }


}
