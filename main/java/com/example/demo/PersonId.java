package com.example.demo;

import jakarta.persistence.*;

@Entity(name = "PersonId")
@Table(name = "person_ids")
public class PersonId {
    @Id()
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    PersonId() {
    }

    public PersonId(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
