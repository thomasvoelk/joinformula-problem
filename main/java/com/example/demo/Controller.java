package com.example.demo;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Testi testi;

    public Controller(Testi testi) {
        this.testi = testi;
    }

    @GetMapping("/")
    public String hello() {
        return testi.transactionTemplate().toString();
    }
}
