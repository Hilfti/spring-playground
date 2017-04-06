package com.example.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by trainer19 on 4/5/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
        private String firstName;
        private String lastName;

        @JsonProperty("FirstName")
        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        @JsonProperty("LastName")
        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }
    }

