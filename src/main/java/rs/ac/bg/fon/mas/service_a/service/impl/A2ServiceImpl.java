/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.mas.service_a.domain.A2;
import rs.ac.bg.fon.mas.service_a.repository.A2Repository;
import rs.ac.bg.fon.mas.service_a.service.A2Service;

/**
 *
 * @author Predrag
 */
@Service
public class A2ServiceImpl implements A2Service {

    @Autowired
    A2Repository repo;
    
    @Override
    public List<A2> findAll() {
        return repo.findAll();
    }

    @Override
    public A2 create(A2 a2) {
        A2 entity = repo.save(a2);
        return entity;
    }

    @Override
    public A2 findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public A2 update(A2 a2) {
        Optional<A2> opt = repo.findById(a2.getId());
        if (opt.isEmpty())
            return null;
        A2 entity = opt.get();
        entity.setName(a2.getName());
        entity.setActive(a2.isActive());
        entity.setCode(a2.getCode());
        A2 changedEntity = repo.save(entity);
        return changedEntity;        
    }

    @Override
    public boolean delete(Long id) {
        Optional<A2> opt = repo.findById(id);
        if (opt.isEmpty())
            return false;
        A2 entity = opt.get();        
        repo.delete(entity);
        return true;
    }

}
