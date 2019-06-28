package com.edgenda.bnc.skillsmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Timestamp starttime;

    @NotEmpty
    private Timestamp endtime;


    @ManyToMany(mappedBy = "events")
    private List<Guest> guests;

    public Event() {
    }

    public Event(Long id, String name, Timestamp starttime, Timestamp endtime, List<Guest> guests) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.guests = guests;
    }

    @PersistenceConstructor
    public Event( String name, Timestamp time, List<Guest> guests) {
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.guests = guests;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getstarttime() {
        return starttime;
    }

    public Timestamp getendtime() {
        return endtime;
    }

    @JsonIgnoreProperties({"employees"})
    public List<Guest> getGuests() {
        return guests;
    }



}
