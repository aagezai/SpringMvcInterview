package com.InterviewCompleteJavaSpring.OOP.ExSerializable;

import com.InterviewCompleteJavaSpring.OOP.Address;

import java.io.*;

// A simple class to be serialized
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Address address;
    private  volatile int age; // Marking 'age' as transient
    //private transient volatile int age; // Marking 'age' as transient
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this. address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }
}

public class TransientExample {
    public static void main(String[] args) {
        // Create an object to be serialized
        Address address = new Address("15423 abc road");
        Person person = new Person("John Doe", 25,address);

        // Serialize the object to a file
        serializeObjectToFile(person, "person.ser");

        // Deserialize the object from the file
        Person deserializedPerson = deserializeObjectFromFile("person.ser");

        // Display the deserialized object
        System.out.println("Deserialized Person: " + deserializedPerson);
    }

    // Method to serialize an object to a file
    private static void serializeObjectToFile(Person object, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
            System.out.println("Object serialized to " + object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize an object from a file
    private static Person deserializeObjectFromFile(String fileName) {
        Person person = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            person = (Person) inputStream.readObject();
            System.out.println("Object deserialized from " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
