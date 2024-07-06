/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.mas.service_a.controller;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rs.ac.bg.fon.mas.service_a.dto.A1Dto;
import rs.ac.bg.fon.mas.service_a.dto.Views;

/**
 *
 * @author Predrag
 */
@RequestMapping("a1")
public interface A1Controller {

    @GetMapping(
            value = "",
            produces = "application/json")
    @JsonView(Views.Internal.class)
    public @ResponseBody ResponseEntity<List<A1Dto>> getA1();

    @GetMapping(
            value = "{id}",
            produces = "application/json")
    @JsonView(Views.Internal.class)
    public @ResponseBody ResponseEntity<A1Dto> getA1ById(@PathVariable Long id);
    
    @PostMapping(
            value = "",
            produces = "application/json")
    @JsonView(Views.Public.class)
    public @ResponseBody ResponseEntity<A1Dto> add(@RequestBody A1Dto a1);
    
}
