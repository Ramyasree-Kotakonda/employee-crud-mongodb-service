package com.example.employee_crud_mongodb_service.model;

import lombok.Data;

@Data
public class EmployeeResponse {

    private String empName;
    private String email;

    private String empId;
    private String id;
}
