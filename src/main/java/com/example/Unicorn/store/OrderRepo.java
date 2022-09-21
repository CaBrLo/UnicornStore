package com.example.Unicorn.store;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {

    private List<Orders> orders = new ArrayList<>();

    public void addOrder(Orders orders) {
        this.orders.add(orders);
    }

    public Orders getOrder(Long orderNumber) {
        for (Orders orders : this.orders) {
            if (orderNumber == orders.getOrderNumber()) {
                return orders;
            }
        }
        return null;
    }

    public List<Orders> getAllOrders() {
        return orders;
    }
}
