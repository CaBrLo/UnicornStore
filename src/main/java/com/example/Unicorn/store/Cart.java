package com.example.Unicorn.store;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

    @Service

    public class Cart {

    List<Unicorn> unicornCart = new ArrayList<>();



    public Cart() {

    }



    public Unicorn addUnicornToCart(Unicorn unicorn) {
        unicornCart.add(unicorn);
        return unicorn;
    }

    public void deleteUnicornFromCart(Long id) {
        unicornCart.removeIf(unicorn -> unicorn.getId().longValue() == id);
    }


}
