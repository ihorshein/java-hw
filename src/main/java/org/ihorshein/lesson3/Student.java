package org.ihorshein.lesson3;

import java.util.List;

public class Student {
  /**
   * Name of the student.
   */
  String name;

  /**
   * Age of the student.
   */
  int age;

  /**
   * List of Grade objects, each representing the score in a subject.
   */
  List<Grade> grades;

  /**
   * The name of the school the student attends.
   */
  String school;

  /**
   * A nested field with information about the student’s address.
   */
  Address address;
}
