package com.example.gestion_tickets_incidents.repository;

import com.example.gestion_tickets_incidents.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findFirstByNom(String nom);
}
