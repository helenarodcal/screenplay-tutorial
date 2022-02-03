package serenitylabs.tutorials.mvc.dto;

import java.time.LocalDate;
import java.time.Period;

public class Pet {

    private final String name;
//    private final int age;
    private final LocalDate dateOfBirth;

    public Pet(String name,
//               int age,
               LocalDate dateOfBirth) {
        this.name = name;
//        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
