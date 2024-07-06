/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.dto;

import com.fasterxml.jackson.annotation.JsonView;
import rs.ac.bg.fon.mas.service_a.domain.A1;

/**
 *
 * @author Predrag
 */
public class A1Dto {
    
    @JsonView(Views.Internal.class)
    private Long id;
    
    @JsonView(Views.Public.class)
    private String name;
    
    @JsonView(Views.Public.class)
    private boolean isActive;

    public A1Dto() {
    }
    
    public A1Dto(A1 a1) {
        id = a1.getId();
        name = a1.getName();
        isActive = a1.isIsActive();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
