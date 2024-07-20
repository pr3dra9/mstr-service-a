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
        return a2dto -> {
            A2 a2 = new A2();
            a2.setName(a2dto.getName());
            a2.setActive(a2dto.isActive());
            a2.setCode(a2dto.getCode());
            A2  entity = service.create(a2);
            return new A2Dto(entity);
        };
    }
    
    @Bean
    public Function<A2Dto, A2Dto> transformUpdateMessage() {
        return a2dto -> {
            A2 a2 = new A2();
            a2.setId(a2dto.getId());
            a2.setName(a2dto.getName());
            a2.setActive(a2dto.isActive());
            a2.setCode(a2dto.getCode());
            A2  entity = service.update(a2);
            return new A2Dto(entity);
        };
    }
    
    @Bean
    public Function<Long, Boolean> transformDeleteMessage() {
        return id -> {
            return service.delete(id);
        };
    }
    
}
