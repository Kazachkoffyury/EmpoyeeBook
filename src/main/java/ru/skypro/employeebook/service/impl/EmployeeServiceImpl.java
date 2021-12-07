package ru.skypro.employeebook.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employeebook.data.Employee;
import ru.skypro.employeebook.exeption.EmployeeBookFull;
import ru.skypro.employeebook.exeption.EmployeeNotFound;
import ru.skypro.employeebook.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees = new Employee[10];

    @Override
    public String add(String firstName, String secondName) {
        for (int i = 0;i<employees.length;i++) {
            if(employees[i] == null ) {
                employees[i] = new Employee(firstName,secondName);
                return "Сотрудник" + employees[i].getFullName()+ "добавлен";
            }
        }
        throw new EmployeeBookFull();
    }

    @Override
    public  String remove(String firstName, String secondName) {
        for (int i= 0; i<employees.length ; i++) {
            if (firstName.equals(employees[i].getFirstName())&& secondName.equals(employees[i].getSecondName())) {
                employees[i] = null;
                return "Сотрудник Удален!";
            }
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee find(Employee employee) {
        for (int i= 0 ; i<employees.length ; i++){
            if(employees[i].equals(employee.getFirstName())&&employees[i].equals(employee.getSecondName())){
                return employee;
            }
        }
        throw new EmployeeNotFound();
    }
}
