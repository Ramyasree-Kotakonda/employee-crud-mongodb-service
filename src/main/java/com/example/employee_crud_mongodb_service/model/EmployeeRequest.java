package com.example.employee_crud_mongodb_service.model;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String empName;
    private String email;

    private String empId;
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }



}
