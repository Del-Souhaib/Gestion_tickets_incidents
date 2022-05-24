package com.example.gestion_tickets_incidents.service;

import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id){
        return ticketRepository.getById(id);
    }

    public void save(Ticket ticket){
         ticketRepository.save(ticket);
    }

    public void delete(Ticket ticket){
        ticketRepository.delete(ticket);
    }

}
