package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonIdRepository extends JpaRepository<PersonId, Integer> {
}
