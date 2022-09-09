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
import java.util.List;

@Controller
public class UnicornController {
    @Autowired
    private UnicornRepo unicornRepo;

    @Autowired
    private CustomerRepo customerRepo;


    @GetMapping("/unicorns")
    public String unicorns(Model model) {
        List<Unicorn> unicorns = unicornRepo.getUnicorns();
        model.addAttribute("unicorns", unicorns);
        return "unicorns";
    }

    @GetMapping("/unicorn")
    public String unicorn(Model model, @RequestParam( value = "id",required = false,defaultValue = "100000")Long id) {
        Unicorn unicorn = unicornRepo.getUnicorn(id); // todo replace with call GET /book/{id}
        //Book book = restTemplate.getForObject("http://localhost:8080/book/" + id, Book.class);
        model.addAttribute("unicorn", unicorn);

        return "unicorn";
    }

    @PostMapping("/unicorn")
    public String unicornPost(HttpSession session, Long id) {
        Unicorn unicorn = unicornRepo.getUnicorn(id);
        session.setAttribute("unicornId", unicorn.getId());

        return "unicorn";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    /**@PostMapping("/login")
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


    /**@GetMapping("/profile")
    public String profile(HttpSession session) {
        String userName = (String)session.getAttribute("userName");
        if (userName != null) {
            return "profile";
        }
       return "redirect:/";
    }*/

    @GetMapping("/profile")
    public String profile(HttpSession session, HttpServletRequest request) {
        String username = request.getRemoteUser();
        for (Customer customer : customerRepo.getCustomers()) {
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








