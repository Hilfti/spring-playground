package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by trainer19 on 4/4/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightTicketPriceTest {
    @Autowired
    private MockMvc mvc;

    //**************************Test using String literal*********************************

    @Test
    public void testJsonRequest1() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"tickets\": [\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Some name\",\n" +
                        "          \"lastName\": \"Some other name\"\n" +
                        "        },\n" +
                        "        \"price\": 200\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"passenger\": {\n" +
                        "          \"firstName\": \"Name B\",\n" +
                        "          \"lastName\": \"Name C\"\n" +
                        "        },\n" +
                        "        \"price\": 150\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }

    //**************************Test using Gson*********************************

    private Gson gson = new GsonBuilder().create();

    static class FlightTicket {

        private Ticket[] tickets;

        FlightTicket(Ticket[] tickets) {
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

    @Test
    public void testJsonRequest2() throws Exception {
        Ticket ticket1 = new Ticket();
        ticket1.price = 150;

        Ticket ticket2 = new Ticket();
        ticket2.price = 200;

        Person person1 = new Person();
        Person person2 = new Person();

        person1.firstName = "Albert";
        person1.lastName = "Chris";


        person2.firstName = "John";
        person2.lastName = "Oliver";

        ticket1.passenger = person1;
        ticket2.passenger = person2;

        FlightTicket params = new FlightTicket(new Ticket[]{ticket1,ticket2});

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(params));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }

    //**************************Test using file fixture*********************************

    @Test
    public void testJsonRequest3() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}

