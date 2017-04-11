package com.example;

import com.example.Model.Lesson;
import com.example.Model.LessonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer19 on 4/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LessonControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Spring\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class)))
                //.andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Spring")));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetSingleLesson() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Access Single Element");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Access Single Element")))
                .andExpect(jsonPath("$.id", equalTo(lesson.getId().intValue())));
    }

    @Test
    @Transactional
    @Rollback
    public void testList() throws Exception {
        Lesson lesson1 = new Lesson();
        Lesson lesson2 = new Lesson();
        lesson1.setTitle("Title 1");
        lesson2.setTitle("Title 2");
        repository.save(lesson1);
        repository.save(lesson2);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(lesson1.getId().intValue()) ))
                .andExpect(jsonPath("$[1].id", equalTo(lesson2.getId().intValue())))
                .andExpect(jsonPath("$[0].title", is("Title 1")))
                .andExpect(jsonPath("$[1].title", is("Title 2")));
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdate() throws Exception {
        MockHttpServletRequestBuilder request = patch("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"Modified Title\"\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Modified Title")))
                .andExpect(jsonPath("$.id", instanceOf(Number.class)));

    }

    @Test
    @Transactional
    @Rollback
    public void testDelete() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Delete Title");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = delete("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(""));

    }
}



