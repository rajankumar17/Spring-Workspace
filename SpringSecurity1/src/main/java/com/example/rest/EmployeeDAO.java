package com.example.rest;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO
{
    private static EmployeeService list = new EmployeeService();

    static
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public EmployeeService getAllEmployees()
    {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

    public Employee getEmployeeById(Integer id) {
        List<Employee> employeeList = list.getEmployeeList();
        Employee employee = employeeList.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        for (Employee emp : employeeList) {
            if (id.equals(emp.getId())) {
                return emp;
            }
        }
        return null;
    }

    public void updateEmployee(Integer id, Employee entity) {
        List<Employee> employeeList = list.getEmployeeList();
        for (Employee emp : employeeList) {
            if (id.equals(emp.getId())) {
                emp.setEmail(entity.getEmail());
                emp.setFirstName(entity.getFirstName());
                emp.setLastName(entity.getLastName());
                emp.setId(entity.getId());
                return;
            }
        }
        return;
    }
}