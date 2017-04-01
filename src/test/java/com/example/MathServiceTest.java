package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("24.0"));

        RequestBuilder request2 = MockMvcRequestBuilders.post("/math/sum?n=3&n=5&n=7");
        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }
}
