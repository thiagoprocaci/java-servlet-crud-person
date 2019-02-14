package com.tbp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRepository {

    static Map<String, Food> foodMap = new HashMap<String, Food>();

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
