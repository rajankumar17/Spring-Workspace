package com.example.rest;

import java.net.URI;

import com.example.crud.EmployeeEntity;
import com.example.crud.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path="/", produces = "application/json")
    public EmployeeService getEmployees()
    {
        return employeeDao.getAllEmployees();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee employee)
    {
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);

        employeeDao.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable("id") Integer id)
            throws RecordNotFoundException {
        Employee entity = employeeDao.getEmployeeById(id);
        if (null == entity) {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(path= "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee,@Valid @PathVariable("id") Integer id) throws RecordNotFoundException {
        Employee entity = employeeDao.getEmployeeById(id);
        if (null == entity) {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
        employeeDao.updateEmployee(id,employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
