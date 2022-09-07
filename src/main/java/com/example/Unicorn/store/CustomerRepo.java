package com.example.Unicorn.store;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepo {

    private List<Customer> customers;

    public CustomerRepo() {
        customers = new ArrayList<>();
        customers.add(new Customer("woow_man", "1234a5", "asd@hotmail.com", "Johan",
                "Mattsson", "Backsippsgatan 17", "72224", "Vasteras"));
        customers.add(new Customer("cm91", "87qew965", "qwe@gmail.com", "Carl",
                "Mickelson", "Repslagargatan 3B", "97321", "Luleo"));
        customers.add(new Customer("alvisen", "99fge68", "cool@outlook.com", "Alva",
                "Storm", "Nordostpassagen 51", "41311", "Goteborg"));
        customers.add(new Customer("carro_91", "66dee89", "carro_91@hotmail.com", "Caroline",
                "Brander Lof", "Daltorpsgatan 52", "41273", "Goteborg"));
    }

    // Get one customer
    public Customer getCustomer(String userName) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(userName)) {
                return customer;
            }
        }
        return null;
    }

    // get all customers
    public List<Customer> getCustomers() {
        return customers;
    }


    // add a customer. Ändra om. Användare ska välja username själv.
    public Customer addCustomer(Customer customer) {
        Customer lastCustomer = customers.get(customers.size()-1);
        customer.setUsername(lastCustomer.getUsername()+1); // set an id on the new customer, should be unique, will be done by the database in future exercises
        customers.add(customer);
        return customer;
    }

    // edit a customer
    public Customer editBook(Customer customer) {
        Customer customerToEdit = this.getCustomer(customer.getUsername());
        if (customerToEdit != null) {
            customerToEdit.setPassword(customer.getPassword());
            customerToEdit.setEmail(customer.getEmail());
            customerToEdit.setFirstName(customer.getFirstName());
            customerToEdit.setLastName(customer.getLastName());
            customerToEdit.setAddress(customer.getAddress());
            customerToEdit.setZipCode(customer.getZipCode());
            customerToEdit.setCity(customer.getCity());

        }
        return customer;
    }

    // delete a customer
    public void deleteCustomer(String userName) {
        Customer customerToDelete = this.getCustomer(userName);
        if (customerToDelete != null) {
            customers.remove(customerToDelete);
        }
    }


}
