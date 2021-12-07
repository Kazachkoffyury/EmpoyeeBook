package ru.skypro.employeebook.service;

import ru.skypro.employeebook.data.Employee;

public interface EmployeeService {
    String add(String firstName, String secondName);
    String  remove(String firstName,String secondName);
    Employee find(Employee employee);
}
