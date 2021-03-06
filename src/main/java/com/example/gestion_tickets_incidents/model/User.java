package com.example.gestion_tickets_incidents.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    private String username;
    @Column(unique = true)
    private String email;

    private String password;

    @ManyToMany
    private List<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
