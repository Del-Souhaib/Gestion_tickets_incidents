package com.example.gestion_tickets_incidents.repository;

import com.example.gestion_tickets_incidents.model.Role;
import com.example.gestion_tickets_incidents.model.Ticket;
import com.example.gestion_tickets_incidents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);

//    @Query("select u from User u  where u.roles  :role")
    List<User> findFirstByRolesContains(Role role);


}
