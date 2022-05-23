package com.example.gestion_tickets_incidents.repository;

import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);
}
