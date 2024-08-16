package com.amaris.prueba.controller;

import com.amaris.prueba.dto.ModelWrapperDto;
import com.amaris.prueba.entity.ModelWrapper;
import com.amaris.prueba.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @GetMapping(value = "getEmployee/{id}", produces = "application/json")
    public ResponseEntity<?> returnEmployee(@PathVariable("id") String id){
        ModelWrapperDto employee = service.getEmployeeId(id);

        return new ResponseEntity<Object>(employee, HttpStatus.OK);
    }
    @GetMapping(value = "getEmployees", produces = "application/json")
    public ResponseEntity<?> returnEmployees(){
        ModelWrapper employees = service.getEmployees();

        return new ResponseEntity<Object>(employees, HttpStatus.OK);
    }
}
