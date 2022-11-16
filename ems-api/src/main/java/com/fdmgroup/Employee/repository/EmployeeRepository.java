package com.fdmgroup.Employee.repository;

import com.fdmgroup.Employee.entity.EmployeeEntity;
import com.fdmgroup.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {


}
