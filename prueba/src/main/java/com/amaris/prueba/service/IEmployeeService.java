package com.amaris.prueba.service;

import com.amaris.prueba.dto.ModelWrapperDto;
import com.amaris.prueba.entity.Employee;
import com.amaris.prueba.entity.ModelWrapper;

import java.util.List;

public interface IEmployeeService {

    public Integer getAnualSalary(int salary);
    public ModelWrapperDto getEmployeeId(String id);

    public ModelWrapper getEmployees();
}
