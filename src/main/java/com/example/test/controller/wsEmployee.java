package com.example.test.controller;

import com.example.test.entity.Employee;
import com.example.test.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class wsEmployee {

    private final EmployeeService employeeService;

    public wsEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public ResponseEntity <List<Employee>>getEmployees(){
        List<Employee> employees = employeeService.employees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    //cette méthode permet de supprimer un employ
    @GetMapping(value = "/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id){
        return employeeService.employeeById(id);
    }

    @GetMapping(value = "/findEmployee")
    public List<Employee> findEmployee(final @RequestParam("nom") String nom){
        return employeeService.findEmployee(nom);

    }

    @GetMapping(value = "/findPrenomEmployee")
    public Optional<Employee> findNumEmployee(final @RequestParam("prenom") String prenom){
        return employeeService.findPrenomEmployee(prenom);
    }

    @PostMapping(value = "employee/add")
    public void save(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

    }

    @DeleteMapping(value = "employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    /*@RequestMapping("/")
    public String sayHello(){
        return "Bienvenue sur mon application!";
    }*/

    /*@PatchMapping(value = "/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee,Long id){
        Employee res = employeeService.updateEmployee(employee,id);
        return res;
    }*/
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

}
