/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.service;

import java.util.List;
import rs.ac.bg.fon.mas.service_a.domain.A2;

/**
 *
 * @author Predrag
 */
public interface A2Service {
    public List<A2> findAll();
    public A2 findById(Long id);
    public A2 create(A2 a2);
    public A2 update(A2 a2);
    public boolean delete(Long id);
}
