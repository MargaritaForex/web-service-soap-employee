package com.employee.soap.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import soap.employee.Employee;
import soap.employee.EmployeeRequest;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeRepository {

    private static final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void initData() {}

    public Employee findStudent(EmployeeRequest request) {
            Assert.notNull(request.getFullName(), "The Student's name must not be null");
            Employee employee = new Employee();
            employee.setFullName(request.getFullName());
            employee.setLastName(request.getLastName());
            employee.setDocumentType(request.getDocumentType());
            employee.setDocumentNumber(request.getDocumentNumber());
            employee.setRole(request.getRole());
            employees.put(request.getFullName(), employee);
            return employees.get(request.getFullName());
        }


    }

