package com.facebooked.demofacebooked.hibernateAndJpaController;

import com.facebooked.demofacebooked.hibernateAndJpaController.model.YourEntity;
import com.facebooked.demofacebooked.hibernateAndJpaController.service.hibernateAndJpaService.YourJpaService;
import com.facebooked.demofacebooked.hibernateAndJpaController.service.hibernateAndJpaService.YourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class YourController {

    @Autowired
    private YourService hibernateService;

    @Autowired
    private YourJpaService jpaService;

    @GetMapping("/hibernate")
    public List<YourEntity> getAllEntitiesWithHibernate() {
        return hibernateService.getAllEntities();
    }

    @GetMapping("/jpa")
    public List<YourEntity> getAllEntitiesWithJpa() {
        return jpaService.getAllEntities();
    }

    @PostMapping("/hibernate")
    public void saveEntityWithHibernate(@RequestBody YourEntity entity) {
        hibernateService.saveEntity(entity);
    }

    @PostMapping("/jpa")
    public YourEntity saveEntityWithJpa(@RequestBody YourEntity entity) {
        return jpaService.saveEntity(entity);
    }

    @GetMapping("/hibernate/{id}")
    public YourEntity getEntityByIdWithHibernate(@PathVariable Long id) {
        return hibernateService.getEntityById(id);
    }

    @GetMapping("/jpa/{id}")
    public YourEntity getEntityByIdWithJpa(@PathVariable Long id) {
        return jpaService.getEntityById(id);
    }

}
