package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registrationform";
    }

    @PostMapping("/registrationprocess")
    public String registrationForm(@Valid User user, Model model, BindingResult result){
        if(result.hasErrors()) return "registrationform";

        userRepository.save(user);
        model.addAttribute("user",user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "loginform";
    }
}
