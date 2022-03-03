package com.example.relational.Configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class DemoController {

    @GetMapping("/hi")
    public String printHello(){
        return "Hello World";
    }
}
