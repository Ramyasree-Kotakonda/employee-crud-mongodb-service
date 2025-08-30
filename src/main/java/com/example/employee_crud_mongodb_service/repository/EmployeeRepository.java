package com.example.employee_crud_mongodb_service.repository;

import com.example.employee_crud_mongodb_service.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
