package com.example.Unicorn.store;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @OneToOne
    private Customer customer;

    private double orderPrice;
//    @OneToMany
    //private Unicorn unicorn;

    public Orders() {
    }

    public Orders(Long orderNumber, Customer customer, Unicorn unicorn) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        //this.unicorn = unicorn;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
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


}
