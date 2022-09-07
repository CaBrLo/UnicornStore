package com.example.Unicorn.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UnicornController {
    @Autowired
    private UnicornRepo unicornRepo;

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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    /*@GetMapping("/unicorn/100001")
    public String unicorns1(Model model) {
        List<Unicorn> unicorns = unicornRepo.getUnicorns();
        model.addAttribute("unicorns", unicorns);
        return "unicorn";*/

    }








