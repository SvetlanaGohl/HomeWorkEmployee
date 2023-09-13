package skypro.employeeBook.gohl.service;

import org.springframework.stereotype.Service;
import skypro.employeeBook.gohl.dto.Employee;
import skypro.employeeBook.gohl.exception.EmployeeAlreadyAddedException;
import skypro.employeeBook.gohl.exception.EmployeeNotFoundException;
import skypro.employeeBook.gohl.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEE_SIZE = 5;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName){
        if (employees.size()==EMPLOYEE_SIZE){
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName);

        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @Override
    public Employee getEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @Override
    public Collection<Employee> findAll(){
        return employees;
    }
}
