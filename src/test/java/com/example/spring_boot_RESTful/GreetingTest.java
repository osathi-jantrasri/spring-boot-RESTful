package com.example.spring_boot_RESTful;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingTest {
    @Autowired
    private GreetingController greetingController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(greetingController).isNotNull();
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/greeting",
                Greeting.class).content()).contains("Hello, World!");
    }

    @Test
    public void greetingShouldReturnCustomMessage() throws Exception {
        String name = "Spring Community";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/greeting?name=" + name,
                Greeting.class).content()).contains("Hello, " + name + "!");
    }
}
