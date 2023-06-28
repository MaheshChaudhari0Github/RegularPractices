package com.example.dao.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmloyeeDaoImplTest {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test
//    public void getAllDataTest(){
//        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee(101,"Sham",100,"Pune")).toList(),
//                (List<Employee>) new Employee(102,"Ram",200,"PCMC"),
//                (List<Employee>) new Employee(103,"Kam",300,"Nagar")
//        );
//        assertEquals(3,employeeDaoImpl.getAllData().size());
//    }

    public void saveDataTest(){
        Employee employee = new Employee(101,"Mahesh",56,"Pune");
        employeeDaoImpl.saveData(employee);
        verify(employeeRepoImpl, times(1)).save(employee);
    }
    @Test
    public void updateData(){
        Employee employee = new Employee(102,"Ramesh",26,"Wakad");
        employeeDaoImpl.updateData(employee);
        verify(employeeRepoImpl,times(1)).save(employee);
    }

    @Test
    public void deleteData(){
        Employee employee = new Employee(103,"Kamlesh",27,"Pune");
        employeeDaoImpl.deleteData(employee.getEmpId());
        verify(employeeRepoImpl,times(1)).deleteById(employee.getEmpId());
    }

}
