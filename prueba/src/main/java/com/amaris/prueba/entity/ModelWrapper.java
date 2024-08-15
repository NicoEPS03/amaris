package com.amaris.prueba.entity;

import lombok.Data;

import java.util.List;

@Data
public class ModelWrapper {
    private String status;
    private List<Employee> data;
    private String message;
}
