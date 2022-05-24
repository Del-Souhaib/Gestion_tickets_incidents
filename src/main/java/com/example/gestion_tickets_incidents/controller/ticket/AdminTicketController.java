package com.example.gestion_tickets_incidents.controller.ticket;

import com.example.gestion_tickets_incidents.model.Role;
import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.model.User;
import com.example.gestion_tickets_incidents.service.RoleService;
import com.example.gestion_tickets_incidents.service.TicketService;
import com.example.gestion_tickets_incidents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class AdminTicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    public List<User> role(Model model) {
        List<User> devs=userService.findFirstByRolesContains(roleService.findFirstByNom("Role_Administrateur"));
        return devs;
//        return roleService.findFirstByNom("Role_Développeur");
    }

    @GetMapping("")
    public String tickets(Model model) {
        List<Ticket> data= ticketService.findAll();
        List<User> devs=userService.findFirstByRolesContains(roleService.findFirstByNom("Role_Développeur"));
        model.addAttribute("data",data);
        model.addAttribute("devs",devs);

        return "tickets/index";
    }

    @GetMapping("ajouter")
    public String ajouterticket(Model model) {
        Ticket data= new Ticket();
        model.addAttribute("data",data);
        return "tickets/add";
    }

    @PostMapping("ajouter")
    public String ajouterticketclick(@ModelAttribute("data") Ticket data,@AuthenticationPrincipal User user ) {
        data.setClient(user);
        return user.getUsername();
//        ticketService.save(data);
//        return "redirect:/tickets";
    }

    @PostMapping("supprimer/{id}")
    public String supprimer(@PathVariable Long id ) {
        ticketService.delete(ticketService.findById(id));
        return "redirect:/tickets";
    }


    @PostMapping("modifier/{id}/{field}/{newvalue}")
    @ResponseBody
    public String modifier(@PathVariable Long id,@PathVariable String field ,@PathVariable String newvalue) {
        Ticket ticket=ticketService.findById(id);
        if(field.equals("etat"))
            ticket.setEtat(newvalue);
        else if(field.equals("developer"))
            ticket.setDevelopeur(userService.getById(Long.valueOf(newvalue)));
        ticketService.save(ticket);
        return "Modifier success";

    }
}
