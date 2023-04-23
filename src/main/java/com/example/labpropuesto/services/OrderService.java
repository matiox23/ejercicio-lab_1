package com.example.labpropuesto.services;

import com.example.labpropuesto.models.Food;
import com.example.labpropuesto.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {

        private List<Order> orders;
        private List<Food> foods;

        public void addFood(Food food){
        foods.add(food);
        }

        public OrderService(List<Order> orders) {
        this.orders = orders;

        }

        public List<Food> getMenu() {
            List<Food> menu = new ArrayList<>();
            menu.add(new Food("Pizza Americana", "Deliciosa pizza de tomate y queso", 10.0));
            menu.add(new Food("Pizza Hawaina", "Deliciosa pizza de toamte, jamón y piña", 13.0));
            menu.add(new Food("Ensalada César", "Ensalada con pollo, lechuga y aderezo césar", 15.0));
            return menu;
        }

        public Order createOrder(String customerName, String customerEmail, List<Food> food) {
        Order order = new Order(customerName, customerEmail, food);
        orders.add(order);
        return order;
        }

        public List<Order> getAllOrders() {
            return orders;
        }

        public Order getOrderById(Long id) {
            return orders.stream()
                    .filter(order -> order.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        public Order updateOrderStatus(Long id, String status) {
            Order order = getOrderById(id);
            if (order != null) {
                order.setStatus(status);
            }
            return order;
        }

        public void updateOrderStatus(Order order, String status) {
        order.setStatus(status);
        }


}
