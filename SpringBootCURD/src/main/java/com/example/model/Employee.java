package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employe")
public class Employee {
    @Id
    @GeneratedValue

    @Column(name = "emp_id")
    private int empid;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_address")
    private String empAddress;
    @Column(name = "emp_salary")
    private double empSalary;
    @Column(name = "emp_number")
    private long empNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "emp_dates")
    private Date empDOB;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public long getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(long empNumber) {
        this.empNumber = empNumber;
    }

    public Date getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(Date empDOB) {
        this.empDOB = empDOB;
    }
}
