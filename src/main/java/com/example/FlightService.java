package com.example;

import com.example.Model.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer19 on 4/5/17.
 */
public class FlightService {
    public static FlightInfo AssignAFlightData() {

        //Instead of individually inserting the values, we could have instantiated the data using constructor

        FlightInfo flight = new FlightInfo();

        flight.setDeparts(new Date(2017 - 1900, 04, 21));

        Person person = new Person();

        person.setFirstName("Tim");
        person.setLastName("John");

        Ticket ticket = new Ticket();

        ticket.setPrice(200);

        ticket.setPassenger(person);

        flight.setTickets(ticket);

        return flight;

    }

    public static List<FlightInfo> AssignMultipleFlightData() {

        //Instead of individually inserting the values, we could have instantiated the data using constructor

        FlightInfo flight1 = new FlightInfo();
        flight1.setDeparts(new Date(2017 - 1900, 04, 21));

        Person person1 = new Person();
        person1.setFirstName("Tim");
        //person1.setLastName("John");

        Ticket ticket1 = new Ticket();
        ticket1.setPrice(200);

        ticket1.setPassenger(person1);

        flight1.setTickets(ticket1);

        FlightInfo flight2 = new FlightInfo();
        flight2.setDeparts(new Date(2017 - 1900, 04, 21));

        Person person2 = new Person();
        person2.setFirstName("Will");
        person2.setLastName("Smith");

        Ticket ticket2 = new Ticket();
        ticket2.setPrice(400);
        ticket2.setPassenger(person2);
        flight2.setTickets(ticket2);

        return Arrays.asList(flight1, flight2);
    }

    public static Result calcTotal(FlightTicket ticket){
        int total = 0;

        for(Ticket2 tkt : ticket.getTickets()) {
            total+=tkt.getPrice();
        }
        Result myResult = new Result();
        myResult.setResult(total);

        return myResult;

    }

}
