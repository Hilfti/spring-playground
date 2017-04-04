package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by trainer19 on 4/3/17.
 */
@RestController
@RequestMapping("/flights")
public class Flight {
    @GetMapping("/flight")
    public FlightCommonCode.FlightInfo getFlight() {
        return  FlightCommonCode.getFlight();
    }

    @GetMapping("")
    public List<FlightCommonCode.FlightInfo> getMultipleFlightInfos() {
        return  FlightCommonCode.getMultipleFlightInfos();

    }

}




