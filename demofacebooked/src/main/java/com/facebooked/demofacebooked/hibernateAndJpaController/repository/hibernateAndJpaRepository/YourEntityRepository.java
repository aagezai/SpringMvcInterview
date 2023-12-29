package com.facebooked.demofacebooked.hibernateAndJpaController.repository.hibernateAndJpaRepository;

import com.facebooked.demofacebooked.hibernateAndJpaController.model.YourEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YourEntityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveEntity(YourEntity entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
    }

    public YourEntity getEntityById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(YourEntity.class, id);
    }

    public void updateEntity(YourEntity entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
    }

    public void deleteEntity(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        YourEntity entity = currentSession.get(YourEntity.class, id);
        if (entity != null) {
            currentSession.delete(entity);
        }
    }

    public List<YourEntity> getAllEntities() {
        Session currentSession = sessionFactory.getCurrentSession();
        String hql = "FROM YourEntity";
        return currentSession.createQuery(hql, YourEntity.class).getResultList();
    }

    // Additional methods for CRUD operations as needed
}
