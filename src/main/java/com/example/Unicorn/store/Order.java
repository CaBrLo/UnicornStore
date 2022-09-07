package com.example.Unicorn.store;

public class Order {

    private Long orderNumber;
    private Customer customer;
    private Unicorn unicorn;

    public Order(Long orderNumber, Customer customer, Unicorn unicorn) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.unicorn = unicorn;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Unicorn getUnicorn() {
        return unicorn;
    }

    public void setUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }
}
