/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.controller.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.mas.service_a.controller.A2Controller;
import rs.ac.bg.fon.mas.service_a.domain.A2;
import rs.ac.bg.fon.mas.service_a.dto.A2Dto;
import rs.ac.bg.fon.mas.service_a.service.A2Service;

/**
 *
 * @author Predrag
 */
@RestController
public class A2ControllerImpl implements A2Controller{

    @Autowired
    A2Service service; 
    
    @Override
    public ResponseEntity<List<A2Dto>> get() {
        List<A2> a2List = service.findAll();
        List<A2Dto> a2DtoList = new LinkedList();
        for (A2 a2 : a2List) {
            a2DtoList.add(new A2Dto(a2));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a2DtoList);
    }

    @Override
    public ResponseEntity<A2Dto> getById(Long id) {
        A2 a2 = service.findById(id);
        if (a2 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new A2Dto(a2));
    }

    @Override
    public ResponseEntity<A2Dto> create(A2Dto a2Dto) {
        A2 a2 = new A2();
        a2.setName(a2Dto.getName());
        a2.setActive(a2Dto.isActive());
        a2.setCode(a2Dto.getCode());
        
        A2 a2Entity = service.create(a2);
        
        A2Dto resA1Dto = new A2Dto(a2Entity);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resA1Dto);
    }

    @Override
    public ResponseEntity<A2Dto> update(A2Dto a2Dto) {
        A2 a2 = new A2();
        a2.setId(a2Dto.getId());
        a2.setName(a2Dto.getName());
        a2.setActive(a2Dto.isActive());
        a2.setCode(a2Dto.getCode());

        A2 a2Entity = service.update(a2);
        if (a2Entity == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        A2Dto resA1Dto = new A2Dto(a2Entity);
        return ResponseEntity.status(HttpStatus.OK).body(resA1Dto);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (service.delete(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
    
}
