package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

