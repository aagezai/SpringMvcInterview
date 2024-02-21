package com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository.HibernateStatesPersistentTransient;
/*

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateLifecycleExample {

    public static void main(String[] args) {
        // Bootstrap Hibernate
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            // Creating a new entity and saving it to make it persistent
            Person person = new Person();
            person.setFirstName("John");
            person.setLastName("Doe");

            // Transient state
            System.out.println("Transient State: " + person.getId());

            // Save the entity to make it persistent
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(person);
                transaction.commit();
            }

            // Persistent state
            System.out.println("Persisted State: " + person.getId());

            // Detaching the entity from the session
            try (Session session = sessionFactory.openSession()) {
                person.setLastName("UpdatedDoe"); // This change will not be automatically persisted
            }

            // Detached state
            System.out.println("Detached State: " + person.getLastName());

            // Reattaching and merging the entity
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                person = (Person) session.merge(person); // Merging the detached entity
                transaction.commit();
            }

            // Persistent state after reattaching
            System.out.println("Reattached and Merged State: " + person.getLastName());
        }
    }
}
*/
