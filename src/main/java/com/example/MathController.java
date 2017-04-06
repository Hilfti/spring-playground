package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by trainer19 on 4/5/17.
 */
@RestController
@RequestMapping("/math")
public class MathController {
    @PostMapping("/sum")
    public String  sum(@RequestParam MultiValueMap<String, String> querystring)
    {
        return MathService.sum(querystring);
    }

    @GetMapping("/calculate")
    public String compute(@RequestParam(required = false, value = "operation", defaultValue = "add") String operation, @RequestParam double x, @RequestParam double y ){
        return MathService.compute(operation,x,y);
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public double calcVolume(@PathVariable double length,@PathVariable double width,@PathVariable double height)
    {
        return MathService.calcVolume(length,width,height);
    }
    @PostMapping("/area")
    public String calcArea(@RequestParam Map<String, String> params)
    {
        return MathService.calcArea(params);
    }

}
