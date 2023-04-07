package com.example.test.repository;

import com.example.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

   List<Employee> findEmployeeByNom(String name);

   Optional<Employee> findEmployeeByPrenom(String prenom);
}
