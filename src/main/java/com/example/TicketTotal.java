package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer19 on 4/4/17.
 */
@RestController
@RequestMapping("/flights")
public class TicketTotal {

    @PostMapping("/tickets/total")
    public TicketTotalInfo.Result calcTicketTotal(@RequestBody TicketTotalInfo.FlightTicket ticket)
    {
       return TicketTotalInfo.calcTicketTotal(ticket);

    }
}
