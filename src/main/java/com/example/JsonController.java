package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer19 on 4/3/17.
 */
@RestController
@RequestMapping("/json")
public class JsonController {

        @GetMapping("/person")
        public Person getPerson() {
            Person person = new Person();
            person.firstName = "Dwayne";
            person.lastName = "Johnson";
            return person;
        }

        public static class Person {
            private String firstName;
            private String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }
}
