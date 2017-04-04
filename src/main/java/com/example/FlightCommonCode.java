package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer19 on 4/3/17.
 */
public class FlightCommonCode {
    public static FlightInfo getFlight() {
        FlightInfo getFlight = new FlightInfo();
        getFlight.departs = new Date(2017 - 1900, 04, 21);

        Person person = new Person();
        person.firstName = "Tim";
        person.lastName = "John";
        Ticket ticket = new Ticket();
        ticket.price = 200;
        ticket.passenger = person;
        getFlight.tickets = ticket;

        return getFlight;
    }

    public static List<FlightInfo> getMultipleFlightInfos() {
        FlightInfo flight1 = new FlightInfo();
        flight1.departs = new Date(2017 - 1900, 04, 21);

        Person person1 = new Person();
        person1.firstName = "Tim";
        //person1.lastName = "John";
        Ticket ticket1 = new Ticket();
        ticket1.price = 200;
        ticket1.passenger = person1;
        flight1.tickets = ticket1;

        FlightInfo flight2 = new FlightInfo();
        flight2.departs = new Date(2017 - 1900, 04, 21);

        Person person2 = new Person();
        person2.firstName = "Will";
        person2.lastName = "Smith";
        Ticket ticket2 = new Ticket();
        ticket2.price = 400;
        ticket2.passenger = person2;
        flight2.tickets = ticket2;

        return Arrays.asList(flight1, flight2);
    }


    static class FlightInfo {
        private Date departs;
        private Ticket tickets;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonProperty("Departs")
        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date dateTime) {
            this.departs = dateTime;
        }

        @JsonProperty("Tickets")
        public Ticket getTickets() {
            return tickets;
        }

        public void setTickets(Ticket tickets) {
            this.tickets = tickets;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
     static class Person {
        private String firstName;
        private String lastName;

        @JsonProperty("FirstName")
        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        @JsonProperty("LastName")
        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }
    }

    static class Ticket {
        private Person passenger;
        private int price;

        @JsonProperty("Passenger")
        public Person getPassenger() { return passenger; }

        public void setPassenger(Person passenger) { this.passenger = passenger; }

        @JsonProperty("Price")
        public int getPrice() { return price; }

        public void setPrice(int price) { this.price = price; }
    }
}
