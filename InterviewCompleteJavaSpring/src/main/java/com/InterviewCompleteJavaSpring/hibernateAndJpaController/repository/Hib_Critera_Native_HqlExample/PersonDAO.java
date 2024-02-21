package com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository.Hib_Critera_Native_HqlExample;

/*
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // Basic HQL query to retrieve all persons
    public List<Person> getAllPersons() {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<Person> query = currentSession.createQuery("FROM Person", Person.class);
        return query.getResultList();
    }

    // Complex HQL query with a WHERE clause to retrieve persons by last name
    public List<Person> getPersonsByLastName(String lastName) {
        Session currentSession = sessionFactory.getCurrentSession();
        String hql = "FROM Person p WHERE p.lastName = :lastName";
        org.hibernate.query.Query<Person> query = currentSession.createQuery(hql, Person.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    // Complex native SQL query with parameters and conditions
    public List<Person> getPersonsByCustomAgeColumn(int minAge, int maxAge) {
        Session currentSession = sessionFactory.getCurrentSession();
        String nativeQuery = "SELECT * FROM persons WHERE age_age BETWEEN :minAge AND :maxAge";
        org.hibernate.query.Query<Person> query = currentSession.createNativeQuery(nativeQuery, Person.class);
        query.setParameter("minAge", minAge);
        query.setParameter("maxAge", maxAge);
        return query.getResultList();
    }

    // Complex Criteria query to retrieve persons by last name and additional conditions
    public List<Person> getPersonsByLastNameAndAgeRange(String lastName, int minAge, int maxAge) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Person> persons = currentSession.createCriteria(Person.class)
                .add(Restrictions.eq("lastName", lastName))
                .add(Restrictions.between("age", minAge, maxAge))
                .list();
        return persons;
    }
}
*/
