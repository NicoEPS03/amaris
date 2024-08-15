package com.amaris.prueba.service.imp;

import com.amaris.prueba.dto.ModelWrapperDto;
import com.amaris.prueba.entity.Employee;
import com.amaris.prueba.entity.ModelWrapper;
import com.amaris.prueba.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class IEmployeeServiceImp implements IEmployeeService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Integer getAnualSalary(int salary) {
        return salary * 12;
    }

    @Override
    public ModelWrapperDto getEmployeeId(String id) {
        ModelWrapperDto employee = restTemplate.getForObject(
                "https://dummy.restapiexample.com/api/v1/employee/" + id,
                ModelWrapperDto.class);
        employee.getData().setEmployee_anual_salary(getAnualSalary(employee.getData().getEmployee_salary()).toString());
        return employee;
    }

    @Override
    public ModelWrapper getEmployees() {
        ModelWrapper employees = restTemplate.getForObject(
                "https://dummy.restapiexample.com/api/v1/employees",
                ModelWrapper.class);

        List<Employee> employee = employees.getData();
        employee.forEach( x -> {
            x.setEmployee_anual_salary(getAnualSalary(x.getEmployee_salary()).toString());
        });
        return employees;
    }
}
