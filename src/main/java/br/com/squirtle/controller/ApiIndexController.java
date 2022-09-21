package br.com.squirtle.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiIndexController {

    @GetMapping
    public String index() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("status", 200);
        return obj.toString();
    }


}
