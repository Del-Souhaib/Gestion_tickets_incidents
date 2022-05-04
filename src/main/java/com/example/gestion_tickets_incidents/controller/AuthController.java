package com.example.gestion_tickets_incidents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("succeslogin")
    public String succeslogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")){
            return "admin/home";
        }else  if (request.isUserInRole("DEVELOPER")){
            return "developer/home";
        }
        return "bad";
    }
}
