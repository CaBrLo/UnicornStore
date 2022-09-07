package com.example.Unicorn.store;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(Long orderNumber) {
        for (Order order : orders) {
            if (orderNumber == order.getOrderNumber()) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
