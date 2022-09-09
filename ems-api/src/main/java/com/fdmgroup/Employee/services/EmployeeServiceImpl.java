package com.fdmgroup.Employee.services;

import com.fdmgroup.Employee.entity.EmployeeEntity;
import com.fdmgroup.Employee.model.Employee;
import com.fdmgroup.Employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Add a New Employee
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    //Get all the Employees
    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                                    .stream()
                                    .map(emp -> new Employee(
                                            emp.getId(),
                                            emp.getFirstName(),
                                            emp.getLastName(),
                                            emp.getEmailId()))
                                    .collect(Collectors.toList());

        return employees;
    }

    //Delete Employee By ID
    @Override
    public boolean deleteEmployee(long id) {
        //Handle the exception here
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
//        employeeRepository.delete(employeeEntity);
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Employee getEmployeeById(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
