package com.fdmgroup.Employee.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Please Add First Name")
    private String firstName;

    @NotBlank(message = "Please Add Last Name")
    private String lastName;

    @Email(message = "Please Add Valid Email ID")
    @NotBlank
    private String emailId;
}
