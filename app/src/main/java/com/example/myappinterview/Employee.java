package com.example.myappinterview;

import java.io.Serializable;

public class Employee implements Serializable {
  private String nameEmp;
  private String telNum;
  private String sex;
  private int age;

  public Employee(String nameEmp) {
    this.nameEmp = nameEmp;
  }

  public Employee(String nameEmp, String telNum, String sex, int age) {
    this.nameEmp = nameEmp;
    this.telNum = telNum;
    this.sex = sex;
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
