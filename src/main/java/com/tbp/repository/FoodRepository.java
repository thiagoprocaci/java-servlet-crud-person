package com.tbp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRepository {

    static Map<String, Food> foodMap = new HashMap<String, Food>();

    static {
        Food food = new Food();
        food.setPrice(10f);
        food.setIngredients("Tomato");
        food.setName("Salad");

        Food food2 = new Food();
        food2.setPrice(10f);
        food2.setIngredients("Lettuce");
        food2.setName("Salad 2");
        foodMap.put(food2.name, food2);
        foodMap.put(food.name, food);
    }

    public List<Food> findAll() {
        List<Food> foodList = new ArrayList<Food>();
        foodList.addAll(foodMap.values());
        return foodList;
    }

    public void save(Food food) {
        foodMap.put(food.getName(), food);
    }

    public void delete(String name) {
        foodMap.remove(name);
    }

    public Food getByName(String name) {
        return foodMap.get(name);
    }
}
