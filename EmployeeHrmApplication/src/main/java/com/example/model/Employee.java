package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    private String empAddress;
    private int empAge;
    private long empNumber;
    private double empSalary;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;
    private String empEmail;
    private String empPassword;

}
