package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer19 on 4/4/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testASingleFlight() throws Exception {
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"Departs\":\"2017-05-21 06:00\",\"Tickets\":{\"Passenger\":{\"FirstName\":\"Tim\",\"LastName\":\"John\"},\"Price\":200}}"));
    }

    @Test
    public void testMultipleFlights() throws Exception {
        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"Departs\":\"2017-05-21 06:00\",\"Tickets\":{\"Passenger\":{\"FirstName\":\"Tim\"},\"Price\":200}},{\"Departs\":\"2017-05-21 06:00\",\"Tickets\":{\"Passenger\":{\"FirstName\":\"Will\",\"LastName\":\"Smith\"},\"Price\":400}}]"));
    }

}
