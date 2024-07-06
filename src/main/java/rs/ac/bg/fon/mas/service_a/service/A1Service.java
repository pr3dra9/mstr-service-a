/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.service;

import java.util.List;
import rs.ac.bg.fon.mas.service_a.domain.A1;

/**
 *
 * @author Predrag
 */
public interface A1Service {
    public List<A1> findAll();
    public A1 findById(Long id);
    public A1 add(A1 a1);
}
