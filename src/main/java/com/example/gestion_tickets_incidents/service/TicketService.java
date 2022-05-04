package com.example.gestion_tickets_incidents.service;

import com.example.gestion_tickets_incidents.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketService extends JpaRepository<Ticket,Long> {
}
