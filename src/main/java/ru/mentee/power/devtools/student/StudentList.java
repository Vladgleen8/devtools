package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> students;

  public StudentList() {
    students = new ArrayList<>();
  }

  public void addStudent(Student student) {
    if (student != null) {
      students.add(student);
    } else {
      throw new IllegalArgumentException("Некорректное значение Student");
    }
  }

  public List<Student> getStudentsByCity(String city) {
    return students.stream().filter(s -> s.city().equals(city)).toList();
  }
}
