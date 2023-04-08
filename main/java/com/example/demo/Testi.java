package com.example.demo;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class Testi {

    private final UserRepository userRepository;
    private final PersonIdRepository personIdRepository;

    private final TransactionTemplate transactionTemplate;

    private final EntityManager entityManager;

    public Testi(UserRepository userRepository, PersonIdRepository personIdRepository, TransactionTemplate transactionTemplate, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.personIdRepository = personIdRepository;
        this.transactionTemplate = transactionTemplate;
        this.entityManager = entityManager;
    }

    public Integer nothing() {
        var user = new User();
        userRepository.save(user);
        entityManager.detach(user);
        personIdRepository.save(new PersonId(12, userRepository.getReferenceById(user.getId())));
        User u = userRepository.getReferenceById(user.getId());
        PersonId currentPersonId = u.getCurrentPersonId();
        return currentPersonId.getId();
    }
    @Transactional
    public Integer transactionalAnnotation() {
        var user = new User();
        userRepository.save(user);
        entityManager.detach(user);
        personIdRepository.save(new PersonId(12, user));
        User u = userRepository.findById(user.getId()).get();
        PersonId currentPersonId = u.getCurrentPersonId();
        return currentPersonId.getId();
    }
    public Integer transactionTemplate() {
        var user = transactionTemplate.execute(x -> {
            var u = new User();
            userRepository.save(u);
            personIdRepository.save(new PersonId(12, u));
            return u;
        });
        entityManager.detach(user);
        return transactionTemplate.execute(x -> userRepository.findById(user.getId()).get().getCurrentPersonId()).getId();
    }

}
