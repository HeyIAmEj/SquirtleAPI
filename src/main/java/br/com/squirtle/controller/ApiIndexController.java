package br.com.squirtle.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiIndexController {

    @GetMapping
    public String index(){
        return "hello";
    }

    @GetMapping("/api/v1/")
    public String indexapi() {
        return "helloapi";
    }


}
