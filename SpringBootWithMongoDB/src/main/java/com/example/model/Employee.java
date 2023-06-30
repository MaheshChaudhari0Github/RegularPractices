package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private int empid;
    private String empName;
    private  String empAddress;
    private long empNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;
}
