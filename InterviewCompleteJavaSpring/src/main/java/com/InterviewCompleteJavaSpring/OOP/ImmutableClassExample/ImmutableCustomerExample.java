package com.InterviewCompleteJavaSpring.OOP.ImmutableClassExample;

import java.util.ArrayList;
import java.util.List;

// Cart class (Assuming it's mutable for this example)
class Cart implements Cloneable {
    private List<String> items;

    public Cart(List<String> items) {
        this.items = new ArrayList<>(items); // Perform a deep copy during construction
    }

    // Getter for items
    public List<String> getItems() {
        return new ArrayList<>(items); // Return a defensive copy
    }

    // Override clone for deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        Cart clonedCart = (Cart) super.clone();
        clonedCart.items = new ArrayList<>(this.items); // Perform a deep copy
        return clonedCart;
    }
}

// Immutable Customer class
final class Customer implements Cloneable {
    private final String name;
    private final Cart cart;

    // Constructor for initialization
    public Customer(String name, Cart cart) throws CloneNotSupportedException {
        this.name = name;
        // Perform a deep copy of the Cart during construction
        this.cart = (Cart) cart.clone();
    }

    // Getter methods for immutable fields
    public String getName() {
        return name;
    }

    // Return a defensive copy of the Cart to maintain immutability
    public Cart getCart() throws CloneNotSupportedException {
        return (Cart) cart.clone();
    }

    // Clone method for deep copy of Customer
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Customer(this.name, this.cart);
    }
}

public class ImmutableCustomerExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> items = new ArrayList<>();
        items.add("Item1");
        items.add("Item2");

        Cart originalCart = new Cart(items);
        Customer originalCustomer = new Customer("John Doe", originalCart);

        // Display original customer details
        System.out.println("Original Customer: " + originalCustomer.getName());
        System.out.println("Original Cart Items: " + originalCustomer.getCart().getItems());

        // Clone the customer
        Customer clonedCustomer = (Customer) originalCustomer.clone();

        // Modify the original cart (just for demonstration, in practice, it should be immutable)
        originalCart.getItems().add("Item3");

        // Display customer details after modification
        System.out.println("Modified Cart Items in Original Customer: " + originalCustomer.getCart().getItems());
        System.out.println("Cloned Customer Cart Items: " + clonedCustomer.getCart().getItems());
    }
}
