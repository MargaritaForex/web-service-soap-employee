package com.employee.soap.services;

import com.employee.soap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.employee.EmployeeRequest;
import soap.employee.EmployeeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "employee.soap";

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeRequest")
    @ResponsePayload
    public EmployeeResponse getEmployee(@RequestPayload EmployeeRequest request) {
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployee(employeeRepository.findStudent(request));
        return response;
    }
}
