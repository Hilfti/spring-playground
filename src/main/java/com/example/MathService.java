package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by trainer19 on 4/1/17.
 */
@RestController
@RequestMapping("/math")
public class MathService {

    @RequestMapping("/volume/{length}/{width}/{height}")
    public double calcVolume(@PathVariable double length,@PathVariable double width,@PathVariable double height)
    {
        return length*width*height;
    }

    @GetMapping("/calculate")
    public double compute(@RequestParam(required = false, value = "operation", defaultValue = "add") String operation, @RequestParam double x, @RequestParam double y ){
        double result = 0;
        if(operation.equals("add"))
            result = x+y;
        if(operation.equals("subtract"))
            result = x-y;
        if(operation.equals("multiply"))
            result = x*y;
        if(operation.equals("divide"))
            result = x/y;
        return result;
    }

    @PostMapping("/sum")
    public Double sum(@RequestParam MultiValueMap<String, String> querystring)
    {
        double sum = 0;
        for (List<String> n : querystring.values())
            for (String str : n) sum += Double.parseDouble(str);
        return sum;
    }
}
