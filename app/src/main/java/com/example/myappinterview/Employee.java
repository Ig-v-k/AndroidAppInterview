package com.example.myappinterview;

import android.os.Build;

import java.util.Objects;

public class Employee {
  private String nameEmp;
  private String telNum;
  private int age;

  public Employee(String nameEmp, String telNum, int age) {
    this.nameEmp = nameEmp;
    this.telNum = telNum;
    this.age = age;
  }

  public String getNameEmp() {
    return nameEmp;
  }

  public void setNameEmp(String nameEmp) {
    this.nameEmp = nameEmp;
  }

  public String getTelNum() {
    return telNum;
  }

  public void setTelNum(String telNum) {
    this.telNum = telNum;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      return age == employee.age &&
            Objects.equals(nameEmp, employee.nameEmp) &&
            Objects.equals(telNum, employee.telNum);
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      return Objects.hash(nameEmp, telNum, age);
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Employee{" +
          "nameEmp='" + nameEmp + '\'' +
          ", telNum='" + telNum + '\'' +
          ", age=" + age +
          '}';
  }

}
