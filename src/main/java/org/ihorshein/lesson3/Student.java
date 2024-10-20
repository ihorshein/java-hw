package org.ihorshein.lesson3;

import java.util.List;

class Student {
  /**
   * Name of the student.
   */
  private String name;

  /**
   * Age of the student.
   */
  private int age;

  /**
   * List of Grade objects, each representing the score in a subject.
   */
  private List<Grade> grades;

  /**
   * The name of the school the student attends.
   */
  private String school;

  /**
   * A nested field with information about the student’s address.
   */
  private Address address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
