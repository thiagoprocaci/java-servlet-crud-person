package com.tbp.servlet;

import com.tbp.repository.Food;
import com.tbp.repository.FoodRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "food-create-servlet",
        urlPatterns = "/food/create"
)
public class FoodCreateServlet extends HttpServlet{

    FoodRepository foodRepository;


    public FoodCreateServlet() {
        foodRepository = new FoodRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/food/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Float price = Float.parseFloat(req.getParameter("price"));
        String ingredients = req.getParameter("ingredients");
        Food food = new Food();
        food.setName(name);
        food.setIngredients(ingredients);
        food.setPrice(price);
        foodRepository.save(food);
        resp.sendRedirect(req.getContextPath() + "/food/list");
    }
}
