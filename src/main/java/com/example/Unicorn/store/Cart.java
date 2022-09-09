package com.example.Unicorn.store;

import java.util.List;

public class Cart {
    Customer customer;
    Unicorn unicorn;
    List<Unicorn> unicornCart;


    public Cart(Customer customer, Unicorn unicorn) {
        this.customer = customer;
        this.unicorn = unicorn;
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

    public Unicorn addUnicornToCart(Unicorn unicorn) {
        unicornCart.add(unicorn);
        return unicorn;
    }

}
