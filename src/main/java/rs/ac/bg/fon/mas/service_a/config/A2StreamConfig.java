/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.config;

import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.bg.fon.mas.service_a.domain.A2;
import rs.ac.bg.fon.mas.service_a.dto.A2Dto;
import rs.ac.bg.fon.mas.service_a.service.A2Service;

/**
 *
 * @author Predrag
 */
@Configuration
public class A2StreamConfig {
    
    @Autowired
    A2Service service;
    
    @Bean
    public Function<A2Dto, A2Dto> transformCreateMessage() {
        return this::create;
    }
    
    private A2Dto create(A2Dto a2dto) {
        System.out.println("Transform Create Message - " +
            String.format("Name: %s, active: %s, code: %s.", a2dto.getName(), a2dto.isActive(), a2dto.getCode()));
        A2 a2 = new A2();
        a2.setName(a2dto.getName());
        a2.setActive(a2dto.isActive());
        a2.setCode(a2dto.getCode());
        A2  entity = service.create(a2);
        return new A2Dto(entity);
    }
    
    @Bean
    public Function<A2Dto, A2Dto> transformUpdateMessage() {
        return a2dto -> update(a2dto);
    }
    
    private A2Dto update(A2Dto a2dto) {
        System.out.println("Transform Update Message - " +
            String.format("ID: %s, Name: %s, active: %s, code: %s.",a2dto.getId(), a2dto.getName(), a2dto.isActive(), a2dto.getCode()));
        A2 a2 = new A2();
        a2.setId(a2dto.getId());
        a2.setName(a2dto.getName());
        a2.setActive(a2dto.isActive());
        a2.setCode(a2dto.getCode());
        A2  entity = service.update(a2);
        return new A2Dto(entity);
    }
    
    @Bean
    public Function<Long, Boolean> transformDeleteMessage() {
        return id -> {
            System.out.println(String.format("Transform Delete Message - ID: %s.", id));
            return service.delete(id);
        };
    }
    
}
