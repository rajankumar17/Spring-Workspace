package com.example.thyme;

import com.example.crud.EmployeeCrudService;
import com.example.crud.EmployeeEntity;
import com.example.crud.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeThymeLeafController {
    @Autowired
    EmployeeCrudService service;

    @RequestMapping
    public String getAllEmployees(Model model) {
        List<EmployeeEntity> list = service.getAllEmployees();

        model.addAttribute("employees", list);
        String viewPath = "list-employees";
        return viewPath;
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException {
        if (id.isPresent()) {
            EmployeeEntity entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new EmployeeEntity());
        }
        return "add-edit-employee";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(EmployeeEntity employee) throws RecordNotFoundException {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }

}