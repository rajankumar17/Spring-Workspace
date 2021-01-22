package com.example.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeCrudService {

    @Autowired
    EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employeeList = repository.findAll();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    @Cacheable("employee")
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
        System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
        Optional<EmployeeEntity> employee = repository.findById(id);
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = Optional.empty();
        if(null != entity.getId()){
            employee = repository.findById(entity.getId());
        }

        if (employee.isPresent()) {
            EmployeeEntity newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if (employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}