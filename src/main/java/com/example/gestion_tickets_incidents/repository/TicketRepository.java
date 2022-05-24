package com.example.gestion_tickets_incidents.repository;

import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllByDevelopeurIsNull();

    List<Ticket> findAllByDevelopeur_UsernameEquals(String user);

    List<Ticket> findAllByClient_UsernameEquals(String user);

//    List<Ticket> findByDescriptionContainsOrNameContainsOrEtatContainsOrLogicielContainsOrEnvironnementContains(String search);
    List<Ticket> findByDescriptionOrNameOrEtatOrLogicielOrEnvironnementIsContainingAndDevelopeurIsNull(String description, String name, String etat, String logiciel, String environnement);

    List<Ticket> findByDescriptionOrNameOrEtatOrLogicielOrEnvironnementIsContainingAndDevelopeur_UsernameEquals(String description, String name, String etat, String logiciel, String environnement,String user);

    List<Ticket> findByDescriptionOrNameOrEtatOrLogicielOrEnvironnementIsContainingAndClient_UsernameEquals(String description, String name, String etat, String logiciel, String environnement,String user);


}
