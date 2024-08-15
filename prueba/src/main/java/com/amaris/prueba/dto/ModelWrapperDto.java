package com.amaris.prueba.dto;

import com.amaris.prueba.entity.Employee;
import lombok.Data;

@Data
public class ModelWrapperDto {
    private String status;
    private Employee data;
    private String message;
}
