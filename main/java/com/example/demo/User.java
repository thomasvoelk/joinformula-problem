package com.example.demo;

import jakarta.persistence.*;
import org.hibernate.annotations.JoinFormula;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinFormula("select pi.id from person_ids pi limit 1")
    private PersonId currentPersonId;

    public Long getId() {
        return id;
    }

    public PersonId getCurrentPersonId() {
        return currentPersonId;
    }
}
