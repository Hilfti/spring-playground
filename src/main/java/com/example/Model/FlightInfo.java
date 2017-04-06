package com.example.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by trainer19 on 4/5/17.
 */
public class FlightInfo {
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


