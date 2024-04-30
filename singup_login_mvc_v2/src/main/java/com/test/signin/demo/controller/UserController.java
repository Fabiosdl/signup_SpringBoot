package com.test.signin.demo.controller;


import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.test.signin.demo.module.User;

@Controller
public class UserController {

    @GetMapping("/login")
    public String showLogin(){
                
        return "index";
    }

    // add an initbinder... to convert trim input strings
    // remove leading and trailing white spaces
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/register")
    public String registrationPage(Model theModel){
        // can I get the request from the login page and autofill the username and password in the registration page? Try this later
       
        theModel.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/processReg")
    public String registered(@Valid @ModelAttribute ("user") User theUser,
                             BindingResult theBindingResult){ //holds the result of validation

        System.out.println("Password: " + theUser.getPassword() +
                "\nConfirmed Password: " + theUser.getConfirmPassword());

        System.out.println(theBindingResult.toString());

        if(theBindingResult.hasErrors())return "register";
        else return "registered";
    }
}