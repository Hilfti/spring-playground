package com.example;

import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * Created by trainer19 on 4/1/17.
 */

public class MathService {

    public static String calcArea(Map<String, String> params)
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


    public static double calcVolume(double length,double width,double height)
    {
        return length*width*height;
    }


    public static String compute(String operation, double x, double y ){
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

    public static String sum(MultiValueMap<String, String> querystring)
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
