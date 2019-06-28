package com.edgenda.bnc.skillsmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @ManyToMany(mappedBy = "guest")
    private List<Event> events;

    public Guest() {
    }

    public Guest(Long id, String firstName, String lastName, String email, List<Event> events) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
    }

    @PersistenceConstructor
    public Guest(String firstName, String lastName, String email, List<Guest> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnoreProperties({"events"})
    public List<Guest> getEvents() {
        return events;
    }

/*    @PreRemove
    private void removeGuestsFromEmployee() {
        for (Guest guest : event) {
            guest.getEvents().remove(this);
        }*/
    }

}
