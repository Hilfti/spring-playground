package com.example.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by trainer19 on 4/5/17.
 */
public class Ticket {
        private Person passenger;
        private int price;

        @JsonProperty("Passenger")
        public Person getPassenger() { return passenger; }

        public void setPassenger(Person passenger) { this.passenger = passenger; }

        @JsonProperty("Price")
        public int getPrice() { return price; }

        public void setPrice(int price) { this.price = price; }
}
