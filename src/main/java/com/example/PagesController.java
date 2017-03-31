package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer19 on 3/30/17.
 */
@RestController
public class PagesController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/math/pi")
    public double renderPi() {
        return Math.PI;
    }

}

