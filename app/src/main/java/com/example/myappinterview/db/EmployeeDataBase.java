package com.example.myappinterview.db;

import com.example.myappinterview.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
*  Database by locally (for a test's)
*/
public class EmployeeDataBase {
  static private final List<Employee> employeeList = new ArrayList<>(0);

  static {
    initDb();
  }

  static void initDb() {
	employeeList.add(new Employee("A", "00000000000", "Male", 10));
	employeeList.add(new Employee("B", "10000000000", "Female", 20));
	employeeList.add(new Employee("C", "20000000000", "Female", 30));
  }

  public static List<Employee> getAll() {
    return employeeList;
  }

  public static void addEmployee(Employee employee) {
	employeeList.add(employee);
  }

}
