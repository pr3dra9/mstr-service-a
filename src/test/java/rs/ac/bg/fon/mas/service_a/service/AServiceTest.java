/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import rs.ac.bg.fon.mas.service_a.domain.A1;
import rs.ac.bg.fon.mas.service_a.repository.A1Repository;

/**
 *
 * @author Predrag
 */
@SpringBootTest
public class AServiceTest {
    
    @Autowired
    A1Service a1service;
    
    @MockBean
    private A1Repository repo;
    
    @Test
    public void testFindAll() {
        List<A1> a1s = new LinkedList<>();
        a1s.add(new A1());

        when(repo.findAll()).thenReturn(a1s);

        List<A1> dbCatalogs = a1service.findAll();
        Assertions.assertEquals(1, dbCatalogs.size());
    }

    @Test
    public void testFindAllEpmtyList() {
        List<A1> a1s = new LinkedList<>();

        when(repo.findAll()).thenReturn(a1s);

        List<A1> dbCatalogs = a1service.findAll();
        Assertions.assertEquals(0, dbCatalogs.size());
    }
    
    @Test
    public void testFindById() {
        A1 a1 = new A1();
        a1.setId(1L);
        a1.setName("Test");
        a1.setIsActive(true);
        Optional<A1> opt = Optional.of(a1);
        when(repo.findById(1L)).thenReturn(opt);

        A1 dbA1 = a1service.findById(1L);
        Assertions.assertNotNull(dbA1);
        Assertions.assertEquals(Long.valueOf(1), dbA1.getId());
        Assertions.assertEquals("Test", dbA1.getName());
        Assertions.assertTrue(dbA1.isIsActive());
    }
    
    @Test
    public void testFindByIdNull() {
        Optional<A1> opt = Optional.empty();
        
        when(repo.findById(1L)).thenReturn(opt);
        A1 dbA1 = a1service.findById(1L);
        Assertions.assertNull(dbA1);    
    }
    
    @Test
    public void testAdd() {
        A1 a1 = new A1();
        a1.setId(1L);
        a1.setName("Test");
        a1.setIsActive(true);        
        when(repo.save(a1)).thenReturn(a1);
        
        A1 dbA1 = a1service.add(a1);
        Assertions.assertNotNull(dbA1);
        Assertions.assertEquals(Long.valueOf(1), dbA1.getId());
        Assertions.assertEquals("Test", dbA1.getName());
        Assertions.assertTrue(dbA1.isIsActive());
    }
    
}
