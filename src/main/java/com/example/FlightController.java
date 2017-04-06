package com.example;

import com.example.Model.FlightInfo;
import com.example.Model.FlightTicket;
import com.example.Model.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hilfti Yohannes 4/3/17.
 */
@RestController
@RequestMapping("/flights")
public class FlightController {
    @GetMapping("/flight")
    public FlightInfo getAFlightInfo() {

        return FlightService.AssignAFlightData();
    }

    @GetMapping()
    public List<FlightInfo> getMultipleFlightInfos() {

        return FlightService.AssignMultipleFlightData();
    }

    @PostMapping("/tickets/total")
    public Result calcTicketTotal(@RequestBody FlightTicket ticket)
    {
        return FlightService.calcTotal(ticket);
    }

}




