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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.mas.service_a.controller.A1Controller;
import rs.ac.bg.fon.mas.service_a.domain.A1;
import rs.ac.bg.fon.mas.service_a.dto.A1Dto;
import rs.ac.bg.fon.mas.service_a.service.A1Service;

/**
 *
 * @author Predrag
 */
@RestController
public class A1ControllerImpl implements A1Controller {

    @Autowired
    private A1Service service;

    public A1ControllerImpl() {
        super();
    }

    @Override
    public @ResponseBody ResponseEntity<List<A1Dto>> getA1() {
        List<A1> a1List = service.findAll();
        List<A1Dto> a1DtoList = new LinkedList();
        for (A1 a1 : a1List) {
            a1DtoList.add(new A1Dto(a1));
        }
        return ResponseEntity.status(HttpStatus.OK).body(a1DtoList);
    }

    @Override
    public @ResponseBody ResponseEntity<A1Dto> getA1ById(@PathVariable Long id) {
        A1 a1 = service.findById(id);
        if (a1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new A1Dto(a1));
    }

    @Override
    public @ResponseBody ResponseEntity<A1Dto> add(@RequestBody A1Dto a1Dto) {
        A1 a1 = new A1();
        a1.setName(a1Dto.getName());
        a1.setIsActive(a1Dto.isIsActive());
        
        A1 a1Entity = service.add(a1);
        
        A1Dto resA1Dto = new A1Dto(a1Entity);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resA1Dto);
    }

}
