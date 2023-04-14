package com.example.test.service;

import com.example.test.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@DataJpaTest
class EmployeeServiceTest {
    @Mock private EmployeeRepository employeeRepository;
    //private AutoCloseable autoCloseable;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        // On initialise le Mock
        //autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepository);
    }

    /*@AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    void employees() {
        //when
        employeeService.getAllEmployees();
        //then
        verify(employeeRepository).findAll();

        //assertEquals(employeeRepository.findAll(), employeeService.getAllEmployees());

    }

    @Disabled
    @Test
    void findEmployee(String name) {

    }

    @Disabled
    @Test
    void findPrenomEmployee() {
    }

    @Disabled
    @Test
    void employeeById(Long id) {
        //when
        employeeRepository.findById(id);
        //then
        verify(employeeService).employeeById(id);
    }

    @Disabled
    @Test
    void addEmployee() {
    }

    @Disabled
    @Test
    void deleteEmployee() {
    }

    @Disabled
    @Test
    void updateEmployee() {
    }
}