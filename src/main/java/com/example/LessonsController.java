package com.example;

import com.example.Model.Lesson;
import com.example.Model.LessonRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer19 on 4/9/17.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}
