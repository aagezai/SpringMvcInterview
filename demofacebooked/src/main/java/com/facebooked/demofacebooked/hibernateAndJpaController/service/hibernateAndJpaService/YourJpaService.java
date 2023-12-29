package com.facebooked.demofacebooked.hibernateAndJpaController.service.hibernateAndJpaService;

import com.facebooked.demofacebooked.hibernateAndJpaController.model.YourEntity;
import com.facebooked.demofacebooked.hibernateAndJpaController.repository.hibernateAndJpaRepository.YourEntityJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YourJpaService {

    @Autowired
    private YourEntityJpaRepo entityRepository;

    public List<YourEntity> getAllEntities() {
        return entityRepository.findAll();
    }

    public YourEntity saveEntity(YourEntity entity) {
        return entityRepository.save(entity);
    }

    public YourEntity getEntityById(Long id) {
        return entityRepository.findById(id).orElse(null);
    }

    public void updateEntity(YourEntity entity) {
        // Spring Data JPA automatically handles updates when using entity objects
        // No specific update method is needed here
    }

    public void deleteEntity(Long id) {
        entityRepository.deleteById(id);
    }

    // Additional methods for CRUD operations as needed
}
