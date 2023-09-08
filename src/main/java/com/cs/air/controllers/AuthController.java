package com.cs.air.controllers;

import com.cs.air.models.Person;
import com.cs.air.services.RegistrationService;
import com.cs.air.util.PeopleValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PeopleValidator peopleValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(PeopleValidator peopleValidator, RegistrationService registrationService) {
        this.peopleValidator = peopleValidator;
        this.registrationService = registrationService;
    }


    @GetMapping("/login")
    public String loginPage(){
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person){
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        peopleValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }


        registrationService.register(person);
        return "redirect:/auth/login"; //После регистрации нужно аутентифицироваться
    }
}
