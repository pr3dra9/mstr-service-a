/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.dto;

import java.util.Objects;
import rs.ac.bg.fon.mas.service_a.domain.A2;

/**
 *
 * @author Predrag
 */
public class A2Dto {
    private Long id;
    private String name;
    private boolean active;
    private int code;

    public A2Dto() {
    }
    
    public A2Dto(Long id, String name, boolean isActive, int code) {
        this.id = id;
        this.name = name;
        this.active = isActive;
        this.code = code;
    }

    public A2Dto(A2 a2) {
        if(a2.getId() != null) {
            this.id = a2.getId();
        }
        this.name = a2.getName();
        this.active = a2.isActive();
        this.code = a2.getCode();
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + (this.active ? 1 : 0);
        hash = 17 * hash + this.code;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final A2Dto other = (A2Dto) obj;
        if (this.active != other.active) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
