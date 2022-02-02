package serenitylabs.tutorials.trains.dto;

import io.cucumber.java.bs.A;

public class Customer {
    private String title;
    private String firstName;
    private String lastName;

    public Customer(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class ACustomer {
        private String title;
        private String firstName = "";

        public ACustomer(String title) {
            this.title = title;
        }

        public static ACustomer withTitle(String title) {
            return new ACustomer(title);
        }

        public ACustomer andFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Customer andLastName(String lastName) {
            return new Customer(title, firstName, lastName);
        }
    }
}
