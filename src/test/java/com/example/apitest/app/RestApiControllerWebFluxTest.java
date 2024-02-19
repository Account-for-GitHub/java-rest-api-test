package com.example.apitest.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = RestApiController.class)
class RestApiControllerWebFluxTest {
    @Test
    void getResponse(@Autowired WebTestClient client) {
        client.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"elementNumber\": 0}")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.EXPECTATION_FAILED);

        client.post()
                .uri("/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"elementNumber\": 1}")
                .exchange()
                .expectStatus().isOk();
    }
}
