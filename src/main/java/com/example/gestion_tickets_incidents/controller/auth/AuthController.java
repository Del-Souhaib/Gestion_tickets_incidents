package com.example.gestion_tickets_incidents.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/")
public class AuthController {

//    @GetMapping("login")
//    public String login() {
//        return "auth/login2";
//    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('Administrateur2')")
    @isAuthenticated
    public String succeslogin(HttpServletRequest request) {
//        if (request.isUserInRole("ADMIN")){
//            return "index";
//        }else  if (request.isUserInRole("DEVELOPER")){
//            return "index";
//        }
        return "index";
    }
}
