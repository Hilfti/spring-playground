package com.example;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by trainer19 on 4/4/17.
 */
public class TicketTotalInfo {

    public static Result calcTicketTotal(@RequestBody FlightTicket ticket)
    {
        int total = ticket.tickets[0].getPrice() + ticket.tickets[1].getPrice();

        Result myResult = new Result();
        myResult.result = total;

        return myResult;
    }

    static class Result{
        private int result;

        public int getResult(){return result;}
        public void setResult(int total){this.result = result;}
    }

    static class FlightTicket {

        private Ticket[] tickets;

        public Ticket[] getTickets() {
            return tickets;
        }

        public void setTickets(Ticket[] tickets) {
            this.tickets = tickets;
        }
    }

    static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }
    }

    static class Ticket {
        private Person passenger;
        private int price;

        public Person getPassenger() { return passenger; }

        public void setPassenger(Person passenger) { this.passenger = passenger; }

        public int getPrice() { return price; }

        public void setPrice(int price) { this.price = price; }
    }

}
