package com.example.apitest.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestApiController {
    private final HashMap<Integer, String> dataMap = new HashMap<>(
            Map.of(1, "A", 2, "B", 3, "C")
    );

    @PostMapping
    ResponseEntity<String> getResponse(@RequestBody DataRequest request) {
        Integer elementNumber = request.elementNumber;
        String response = dataMap.get(elementNumber);
        if (response == null) {
            return new ResponseEntity<>("data not found", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
