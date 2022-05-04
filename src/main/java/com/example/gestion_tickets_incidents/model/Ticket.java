package com.example.gestion_tickets_incidents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue()
    private Long id;

    private String name;

    private String description;

    @Column( nullable = true)
    private String image;

    public Ticket() {
    }

    public Ticket(Long id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public Ticket( String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
