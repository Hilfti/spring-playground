package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by trainer19 on 4/1/17.
 */
@RestController
@RequestMapping("/math")
public class MathService {

    @PostMapping("/area")
    public String calcArea(@RequestParam Map<String, String> params)
    {
        double radius = 0;
        double width = 0;
        double height = 0;
        double result = 0;

        if(params.get("type").equals("circle") && params.get("radius") != null) {
            radius = Double.parseDouble(params.get("radius"));
            result = Math.PI * Math.pow(radius, 2);
            return "Area of a circle with a radius of " + radius + " is " + result;
        }
        if(params.get("type").equals("rectangle") && (params.get("height") != null) && (params.get("width") != null)) {
            width = Double.parseDouble(params.get("width"));
            height = Double.parseDouble(params.get("height"));
            result = width * height;
            return "Area of " + width + "x" + height + " rectangle is "+ result;
        }

        return "Invalid";

    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public double calcVolume(@PathVariable double length,@PathVariable double width,@PathVariable double height)
    {
        return length*width*height;
    }

    @GetMapping("/calculate")
    public String compute(@RequestParam(required = false, value = "operation", defaultValue = "add") String operation, @RequestParam double x, @RequestParam double y ){
        double result = 0;

        if(operation.equals("add")) {
            result = x + y;
            return  x + "+" + y + " = " + result;
        }
        if(operation.equals("subtract")) {
            result = x - y;
            return  x + "-" + y + " = " + result;
        }
        if(operation.equals("multiply")) {
            result = x * y;
            return  x + "*" + y + " = " + result;
        }
        if(operation.equals("divide")) {
            result = x / y;
            return  x + "/" + y + " = " + result;
        }

        return "Invalid";
    }

    @PostMapping("/sum")
    public String  sum(@RequestParam MultiValueMap<String, String> querystring)
    {
        String output = "";
        double sum = 0;
        for (List<String> n : querystring.values()) {
            for (String str : n) {
                sum += Double.parseDouble(str);
                output = output + str + " + ";
            }
        }
        output = output.substring(0,output.length()-2);
        return output + " = " + sum ;
    }
}
