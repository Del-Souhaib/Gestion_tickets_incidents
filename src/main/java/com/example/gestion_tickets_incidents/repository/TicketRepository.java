package com.example.gestion_tickets_incidents.repository;

import com.example.gestion_tickets_incidents.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
