/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import rs.ac.bg.fon.mas.service_a.domain.A1;
import rs.ac.bg.fon.mas.service_a.dto.A1Dto;
import rs.ac.bg.fon.mas.service_a.service.A1Service;

/**
 *
 * @author Predrag
 */
@WebMvcTest(controllers = A1Controller.class)
public class A1ControllerTest {
    @MockBean
    private A1Service a1Service;
    
    @Autowired
    private MockMvc mockMvc;
    
    ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void testGetAll() throws Exception {
        List<A1> list = new LinkedList<>();
        list.add(new A1());
        list.add(new A1());
        
        when(a1Service.findAll()).thenReturn(list);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/a1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));
    }
    
    @Test
    public void testGetById() throws Exception {
        A1 a1 = new A1();
        a1.setId(1L);
        a1.setName("Test");
        a1.setIsActive(true);
        
        when(a1Service.findById(a1.getId())).thenReturn(a1);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/a1/" + a1.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());  
    }
    
    @Test
    public void testGetNoA1() throws Exception {
        when(a1Service.findById(Long.valueOf(1))).thenReturn(null);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/a1/" + 1))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    
    @Test
    public void testAdd() throws Exception {
        A1 a1 = new A1();
        a1.setName("Test");
        a1.setIsActive(true);
        
        A1Dto a1dto = new A1Dto(a1);
        
        when(a1Service.add(a1)).thenReturn(a1);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/a1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(a1dto)))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
}
