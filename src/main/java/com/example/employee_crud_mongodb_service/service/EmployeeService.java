package com.example.employee_crud_mongodb_service.service;

import com.example.employee_crud_mongodb_service.entity.Employee;
import com.example.employee_crud_mongodb_service.model.EmployeeRequest;
import com.example.employee_crud_mongodb_service.model.EmployeeResponse;
import com.example.employee_crud_mongodb_service.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
@Autowired
private ModelMapper modelMapper;
    public EmployeeResponse saveEmployee(EmployeeRequest employee){

        Employee emp=new Employee();
        emp.setEmpName(employee.getEmpName());
        emp.setEmail(employee.getEmail());
        emp.setEmpId(employee.getEmpId());
        Employee saved=employeeRepository.save(emp);

        return modelMapper.map(saved,EmployeeResponse.class);
    }

    public List<EmployeeResponse> getAllEmployees(){

        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map(emp->modelMapper.map(emp,EmployeeResponse.class)).collect(Collectors.toList());

    }
    public EmployeeResponse getAllEmployeeById(String id){

        Optional<Employee> employee= employeeRepository.findById(id);
        return modelMapper.map(employee,EmployeeResponse.class);

    }

    public void deleteEmployee(String id) throws Exception {

        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new Exception(" Employee not found with id:"+id));
        employeeRepository.delete(employee);

    }


    public EmployeeResponse updateEmployee(String id,EmployeeRequest request) throws Exception {

        Optional<Employee> getEmployeeById= employeeRepository.findById(id);

        if (getEmployeeById.isEmpty()){
            throw new Exception("Employee not found with id:"+id);
        }
        Employee employee= getEmployeeById.get();
        employee.setEmpName(request.getEmpName());
        employee.setEmail(request.getEmail());

        Employee updated=employeeRepository.save(employee);

        return modelMapper.map(updated,EmployeeResponse.class);

    }


}
