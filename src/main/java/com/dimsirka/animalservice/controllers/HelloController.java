package com.dimsirka.animalservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping(value = "/hello", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getHelloSentence(@RequestParam String name){
        return "<h2 style=\"font-family:verdana; color:green;\">"
                + String.format("Hello, %s !\n", name) + "</h2>";
    }
}
