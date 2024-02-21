package com.InterviewCompleteJavaSpring.hibernateAndJpaController.service.hibernateAndJpaService;

import com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository.hibernateAndJpaRepository.YourEntityRepository;
import com.InterviewCompleteJavaSpring.hibernateAndJpaController.model.YourEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class YourService {

    @Autowired
    private YourEntityRepository entityDAO;

    public List<YourEntity> getAllEntities() {
        return entityDAO.getAllEntities();
    }

    public void saveEntity(YourEntity entity) {
        entityDAO.saveEntity(entity);
    }

    public YourEntity getEntityById(Long id) {
        return entityDAO.getEntityById(id);
    }

    public void updateEntity(YourEntity entity) {
        entityDAO.updateEntity(entity);
    }

    public void deleteEntity(Long id) {
        entityDAO.deleteEntity(id);
    }

    // Additional methods for CRUD operations as needed
}
