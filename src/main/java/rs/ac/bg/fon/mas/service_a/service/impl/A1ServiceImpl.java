/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.mas.service_a.domain.A1;
import rs.ac.bg.fon.mas.service_a.repository.A1Repository;
import rs.ac.bg.fon.mas.service_a.service.A1Service;

/**
 *
 * @author Predrag
 */
@Service
public class A1ServiceImpl implements A1Service {

    @Autowired
    A1Repository repo;
    
    @Override
    public List<A1> findAll() {
        return repo.findAll();
    }

    @Override
    public A1 add(A1 a1) {
        return repo.save(a1);
    }

    @Override
    public A1 findById(Long id) {
        Optional<A1> opt = repo.findById(id);
        if (opt.isEmpty())
            return null;
        return opt.get();
    }
    
    
}
