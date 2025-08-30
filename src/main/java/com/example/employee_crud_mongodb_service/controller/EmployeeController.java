package com.example.employee_crud_mongodb_service.controller;

import com.example.employee_crud_mongodb_service.model.EmployeeRequest;
import com.example.employee_crud_mongodb_service.model.EmployeeResponse;
import com.example.employee_crud_mongodb_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
      @Autowired
      private EmployeeService employeeService;
@PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employee){

        EmployeeResponse response= employeeService.saveEmployee(employee);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){

    List<EmployeeResponse> response=employeeService.getAllEmployees();
    return ResponseEntity.ok(response);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> getAllEmployeeById(@PathVariable String id){

        EmployeeResponse response=employeeService.getAllEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) throws Exception {
        employeeService.deleteEmployee(id);
    return  ResponseEntity.ok("Employee with Id "+id+ "has been deleted");
    }

    @PatchMapping("/updateEmployeeById/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable String id, EmployeeRequest request) throws Exception {

    EmployeeResponse response=employeeService.updateEmployee(id,request);
    return ResponseEntity.ok(response);
    }

}
