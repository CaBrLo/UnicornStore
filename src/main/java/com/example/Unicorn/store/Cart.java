package com.example.Unicorn.store;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
//@Entity
public class Cart {
    //Customer customer;
    //Unicorn unicorn;
    List<Unicorn> unicornCart = new ArrayList<>();



    public Cart() {
        //this.customer = customer;
        //this.unicorn = unicorn;
    }



    //public Customer getCustomer() {
        //return customer;
    //}

    //public void setCustomer(Customer customer) {
        //this.customer = customer;
    //}

    /*public Unicorn getUnicorn() {
        return unicorn;
    }*/

    /**public void setUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }*/

    public Unicorn addUnicornToCart(Unicorn unicorn) {
        unicornCart.add(unicorn);
        return unicorn;
    }

    public void deleteUnicornFromCart(Long id) {
        //unicornCart.remove(unicorn);
        unicornCart.removeIf(unicorn -> unicorn.getId().longValue() == id);
    }
    /*
    public void deleteUnicornFromCart(Long id) {
        for (Unicorn unicorn : unicornCart) {
            if (unicorn.getId().longValue() == id) {
                unicornCart.remove(unicorn);
                //unicornCart.remove(unicorn);
            }

        }
    }
     */

}
