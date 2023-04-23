package com.example.labpropuesto.controllers;

import com.example.labpropuesto.models.Food;
import com.example.labpropuesto.models.Order;
import com.example.labpropuesto.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/foods")
    public ResponseEntity<List<Food>> getMenu() {
        return ResponseEntity.ok(this.orderService.getMenu());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order request) {
        Order order = orderService.createOrder(request.getCustomerName(), request.getCustomerEmail(), request.getItems());
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/orders/{id}/status")
    public ResponseEntity<String> getOrderStatus(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        String status = order.getStatus();
        return ResponseEntity.ok(status);
    }

    @PostMapping("/foods")
    public Food createFood(@RequestBody Food food) {
        return food;
    }





}
