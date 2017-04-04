package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by trainer19 on 4/1/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MathService.class)
public class MathServiceTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testHomePage() throws Exception {

        //***********************************************************************************

        MockHttpServletRequestBuilder request6 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "5");

        this.mvc.perform(request6)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

        //***********************************************************************************

        MockHttpServletRequestBuilder request5 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height","7");

        this.mvc.perform(request5)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of 4.0x7.0 rectangle is 28.0"));


        //***********************************************************************************

        MockHttpServletRequestBuilder request4 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request4)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4.0 is 50.26548245743669"));

        //***********************************************************************************

        double length=3;
        double width=4;
        double height=10;

        RequestBuilder request3 = MockMvcRequestBuilders.patch(String.format("/math/volume/%f/%f/%f", length,width,height));
        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string("120.0"));

        //***********************************************************************************

        RequestBuilder request2 = post("/math/sum?n=3&n=5&n=7");
        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 5 + 7  = 15.0"));

        //***********************************************************************************

        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4.0*6.0 = 24.0"));

    }
}
