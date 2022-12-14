package com.app.conditionnal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static GenericContainer<?> devapp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private static GenericContainer<?> prodapp =new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @Test
    void contextLoads() {

        ResponseEntity<String> devappEntity = restTemplate.getForEntity("http://localhost:"
                +  devapp.getMappedPort(8080) + "/profile", String.class);

        System.out.println("devapp " + devappEntity.getBody());


        ResponseEntity<String> prodappEntity = restTemplate.getForEntity("http://localhost:"
                + prodapp.getMappedPort(8081) + "/profile", String.class);

        System.out.println("devapp " + prodappEntity.getBody());

        String result1 = "Current profile is dev";
        String expected1 = devappEntity.getBody();
        Assertions.assertEquals(result1, expected1);
        String result2 = "Current profile is production";
        String expected2 = prodappEntity.getBody();
        Assertions.assertEquals(result2, expected2);
    }
}