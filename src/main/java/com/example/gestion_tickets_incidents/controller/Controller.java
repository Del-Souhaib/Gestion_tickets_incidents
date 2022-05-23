package com.example.gestion_tickets_incidents.controller;

import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@PreAuthorize("hasAnyRole('ADMIN','DEVELOPER')")
public class Controller {
    @Autowired
    private TicketRepository ticketService;


    @GetMapping("")
    public List<Ticket> get() {
        return ticketService.findAll();
    }

    @PostMapping("")
    public Ticket add(Ticket ticket) {
        return ticketService.save(ticket);
    }
}
