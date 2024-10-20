package org.ihorshein.lesson3;

import java.math.BigDecimal;
import java.util.List;

/**
 * <a href="https://docs.google.com/document/d/1WjtbLtapXOIfDh_I9dmdtTmVv-edzFjX_nbpLOCs8kw/edit">
 *   Lesson 3 HW
 * </a>
 */
public final class Main {
  public static void main(String[] args) {
    Address address1 = new Address("New York", "Street1");
    Address address2 = new Address("City2", "Street2");

    Student student1 = new Student();
    student1.setName("John");
    student1.setAge(18);
    student1.setAddress(address1);
    student1.setSchool("School 142");
    student1.setGrades(List.of(
      new Grade("History", 176.4),
      new Grade("Mathematics", 183.23),
      new Grade("Economy", 197.98),
      new Grade("Programming", 205)
    ));

    Student student2 = new Student();
    student2.setName("Tony");
    student2.setAge(21);
    student2.setAddress(address2);
    student2.setSchool("School 34");
    student2.setGrades(List.of(
      new Grade("History", 141.62),
      new Grade("Mathematics", 173.56),
      new Grade("Economy", 169.1),
      new Grade("Programming", 170.45)
    ));

    Student student3 = new Student();
    student3.setName("Anton");
    student3.setAge(14);
    student3.setAddress(address1);
    student3.setSchool("School 142");
    student3.setGrades(List.of(
      new Grade("History", 144.4),
      new Grade("Mathematics", 112.23),
      new Grade("Economy", 134.98),
      new Grade("Programming", 151.98)
    ));

    Student student4 = new Student();
    student4.setName("Taras");
    student4.setAge(19);
    student4.setAddress(address1);
    student4.setSchool("School 31");
    student4.setGrades(List.of(
      new Grade("History", 190.12),
      new Grade("Mathematics", 199.46),
      new Grade("Economy", 189.2),
      new Grade("Programming", 198.31)
    ));

    List<Student> students = List.of(student1, student2, student3, student4);

    record StudentGradeRecord(String studentName, String school, String subject, double score) {
      @Override
      public String toString() {
        return studentName + ", " + school + ", " + subject + ", " + score;
      }
    }

    students.stream()
      .filter(student -> student.getAge() > 15 && student.getAddress().getCity().equals("New York"))
      .flatMap(student -> student.getGrades().stream()
        .map(grade -> new StudentGradeRecord(student.getName(), student.getSchool(), grade.getSubject(), grade.getScore()))
      )
      .sorted((left, right) -> BigDecimal.valueOf(right.score()).compareTo(BigDecimal.valueOf(left.score())))
      .limit(3)
      .forEach(System.out::println);
  }
}
