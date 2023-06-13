package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int emp_id;
    private String emp_Name;
    private String emp_Address;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date emp_DOB;
    @Column(unique = true)
    private long emp_Number;
    private double emp_salary;
    private String emp_Email;
    private String emp_Password;


}
