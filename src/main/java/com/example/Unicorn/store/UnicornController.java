package com.example.Unicorn.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.List;

@Controller
public class UnicornController {
   /* @Autowired
    private UnicornRepo unicornRepo;

    @Autowired
    private CustomerRepo customerRepo;

    */
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private UnicornRepository unicornRepo;

    /*@Autowired
    private Cart cart;
    */


    @GetMapping("/unicorns")
    public String unicorns(Model model, HttpSession session, HttpServletRequest request) {
        String username = request.getRemoteUser();
        //for (Customer customer : customerRepo.getCustomers()) {           //den gamla versionen
        for (Customer customer : customerRepo.findAll()) {
            if (customer.getUsername().equals(username)) {
                session.setAttribute("username", customer.getUsername());
                session.setAttribute("firstname", customer.getFirstName());
                session.setAttribute("lastname", customer.getLastName());
                session.setAttribute("address", customer.getAddress());
                session.setAttribute("zipCode", customer.getZipCode());
                session.setAttribute("city", customer.getCity());
            }
        }
        //List<Unicorn> unicorns = unicornRepo.getUnicorns();               //den gamla versionen
        List<Unicorn> unicorns = (List<Unicorn>)unicornRepo.findAll();
        model.addAttribute("unicorns", unicorns);
        return "unicorns";
    }

    @GetMapping("/unicorn")
    public String unicorn(Model model, @RequestParam( value = "id",required = false,defaultValue = "100000")Long id) {
        //Unicorn unicorn = unicornRepo.getUnicorn(id);                     //den gamla versionen
        Unicorn unicorn = unicornRepo.findById(id).orElse(null);
        //Book book = restTemplate.getForObject("http://localhost:8080/book/" + id, Book.class);
        model.addAttribute("unicorn", unicorn);

        return "unicorn";
    }

    @PostMapping("/unicorn")
    public String unicornPost(Model model, HttpSession session, @RequestParam(value = "id") Long id, HttpServletRequest request) {
        if (request.getRemoteUser() == null) {
            return "login";
        }

        //Unicorn unicorn = unicornRepo.getUnicorn(id);                     //den gamla versionen
        Unicorn unicorn = unicornRepo.findById(id).orElse(null);

        //model.addAttribute("unicorn", unicorn);
        String user = request.getRemoteUser();
        //Customer customer = customerRepo.getCustomer(user);               //den gamla versionen
        Long userId = 0L;
        for(Customer customer : customerRepo.findAll()){
            if(customer.getUsername().equals(request.getRemoteUser())){
                userId = customer.getId();
            }
        }
        Customer customer = customerRepo.findById(userId).orElse(null);
        // Johan har lagt till
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        else {
            cart = (Cart) session.getAttribute("cart");
        }


        cart.addUnicornToCart(unicorn);
        int cartSize = cart.unicornCart.size();
        session.setAttribute("unicornCart", cart.unicornCart);
        session.setAttribute("amount", cartSize);
        session.setAttribute("unicornName", unicorn.getName());
        session.setAttribute("unicornId", unicorn.getId());
        return "unicornAdded";
    }

    @GetMapping("/unicornAdded")
        public String unicornAdded(Model model, HttpSession session) {
        Unicorn unicorn = (Unicorn) model.getAttribute("unicorn");

        return "unicornAdded";
    }

    @GetMapping("/cart")
    public String cart(HttpServletRequest request, HttpSession session, Model model) {
        String user = request.getRemoteUser();
        //Customer customer = customerRepo.getCustomer(user);           //den gamla versionen
        Long userId = 0L;
        for(Customer customer : customerRepo.findAll()){
            if(customer.getUsername().equals(request.getRemoteUser())){
                userId = customer.getId();
            }
        }
        Customer customer = customerRepo.findById(userId).orElse(null);

        double totalAmount = 0;
        // Johan har lagt till
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
        }
        cart = (Cart) session.getAttribute("cart");

        for (Unicorn unicorn : cart.unicornCart) {
            totalAmount += unicorn.getPrice();
        }
        model.addAttribute("totalAmount", totalAmount);

        return "cart";
    }

    @PostMapping("/cart")
    public String cartPost(HttpServletRequest request, HttpSession session, Model model, @RequestParam(value = "id") Long id) {

        // Johan har lagt till
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
        }
        cart = (Cart) session.getAttribute("cart");
        cart.deleteUnicornFromCart(id);

        int cartSize = (int)session.getAttribute("amount");
        cartSize = cartSize - 1;
        session.setAttribute("amount", cartSize);



        return "redirect:/cart";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    /*@PostMapping("/login")
    public String loginPost(HttpSession session, @RequestParam String username, @RequestParam String password) {
        for (Customer customer : customerRepo.getCustomers()) {
            if (username.equals(customer.getUsername()) && password.equals(customer.getPassword()) ){
                session.setAttribute("username", username);
                return "profile";
            }
        }
        return "login";
    }*/

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }




    @GetMapping("/profile")
    public String profile(HttpSession session, HttpServletRequest request) {
        String username = request.getRemoteUser();
        //for (Customer customer : customerRepo.getCustomers()) {               //den gamla versionen
        for (Customer customer : customerRepo.findAll()) {
            if (customer.getUsername().equals(username)) {
                session.setAttribute("username", customer.getUsername());
                session.setAttribute("firstname", customer.getFirstName());
                session.setAttribute("lastname", customer.getLastName());
                session.setAttribute("address", customer.getAddress());
                session.setAttribute("zipCode", customer.getZipCode());
                session.setAttribute("city", customer.getCity());
            }
        }
        return "profile";
    }





}








