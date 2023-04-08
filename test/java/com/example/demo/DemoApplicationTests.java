package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private Testi testi;
	@Autowired
	TransactionTemplate transactionTemplate;

	@Test
	void contextLoads() {
		// var p1 = testi.transactionalAnnotation();
		var p2 = testi.transactionTemplate();
		// var p3 = testi.nothing();
		// System.out.println("@Transactional: " + p1);
		assertEquals(12, p2);
		// System.out.println("Nothing: " + p3);
	}

}
