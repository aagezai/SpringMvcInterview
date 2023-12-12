package com.facebooked.demofacebooked.designPattern.BuilderDesignPattern;

// Product class
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    // Private constructor to enforce the use of the Builder
    private Person() {
    }

    // Getter methods

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Builder class
    static class Builder {
        private Person person;

        // Initialize the Person instance in the builder
        public Builder() {
            person = new Person();
        }

        // Setter methods in the builder for constructing the Person
        public Builder setFirstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            person.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            person.address = address;
            return this;
        }

        // Build method to return the fully constructed Person
        public Person build() {
            return person;
        }
    }
}

// Example usage
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the Builder to create a Person
        Person person = new Person.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(25)
                .setAddress("123 Main St")
                .build();

        // Displaying the created Person
        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
    }
}
