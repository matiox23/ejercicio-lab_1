package com.example.labpropuesto.controllers;


import com.example.labpropuesto.models.Food;
import com.example.labpropuesto.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/menu")
    public List<Food> getMenu() {
        return orderService.getMenu();
    }



}



