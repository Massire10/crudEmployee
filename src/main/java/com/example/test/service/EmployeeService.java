package com.example.test.service;

import com.example.test.entity.Employee;
import com.example.test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();

    }

    public List<Employee> findEmployee(final String nom){
        return employeeRepository.findEmployeeByNom(nom);

    }

    public Optional<Employee> findPrenomEmployee(final String prenom){
        return employeeRepository.findEmployeeByPrenom(prenom);
    }

    public Optional<Employee> employeeById(Long id){
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee employee){
         employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

   /* public Employee updateEmployee(Employee employee,Long id){

        Employee emp = employeeRepository.getReferenceById(id);

        emp.setAge(employee.getAge());
        emp.setPoste(employee.getPoste());

        return employeeRepository.save(emp);
    }*/

    public Employee updateEmployee(Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }


}
