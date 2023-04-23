package com.example.labpropuesto.services;

import com.example.labpropuesto.models.Food;
import com.example.labpropuesto.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public List<Food> getMenu() {
        List<Food> menu = new ArrayList<>();
        menu.add(new Food("Pizza Americana", " Pizza de tomate, queso y jamon", 15.0));
        menu.add(new Food("Pizza Hawaina", "Pizza de tomate, queso, jamon y piña", 17.0));
        menu.add(new Food("Royal Cheese", "Hamburguesa con: huevo y queso", 12.0));
        return menu;
    }

    public  Order createOrder(String customerName, String customerEmail, List<Long> itemIds) {
        List<Food> items = getMenu().stream().filter(food -> itemIds.contains(food.getDescription())).collect(Collectors.toList());
        Order order = new Order(customerName, customerEmail, items);
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(Long id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElse(null);

    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setStatus(status);
        }
        return order;
    }

}
