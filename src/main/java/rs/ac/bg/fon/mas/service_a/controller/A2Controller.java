/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rs.ac.bg.fon.mas.service_a.dto.A2Dto;

/**
 *
 * @author Predrag
 */
@RequestMapping("a2")
public interface A2Controller {
    
    @GetMapping(value = "/",
            produces = "application/json")
    public @ResponseBody ResponseEntity<List<A2Dto>> get();
    
    @GetMapping(value = "/{id}",
            produces = "application/json")
    public  @ResponseBody ResponseEntity<A2Dto> getById(@PathVariable Long id);
    
    @PostMapping(value = "/",
            produces = "application/json")
    public @ResponseBody ResponseEntity<A2Dto> create(@RequestBody A2Dto a2Dto);

    @PutMapping(value = "/",
            produces = "application/json")
    public @ResponseBody ResponseEntity<A2Dto> update(@RequestBody A2Dto a2Dto);

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);
    
}
