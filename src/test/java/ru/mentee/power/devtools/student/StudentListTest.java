package ru.mentee.power.devtools.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование StudentList")
public class StudentListTest {

  @Test
  @DisplayName("Добавление студента")
  void shouldAddStudent() {
    Student student = new Student("Илья", "Ковров");
    StudentList students = new StudentList();
    students.addStudent(student);

    List<Student> studentFromCity = students.getStudentsByCity("Ковров");
    assertEquals(1, studentFromCity.size());
  }

  @Test
  @DisplayName("Добавление студента")
  void shouldNotAddNullStudent() {
    StudentList students = new StudentList();
    students.addStudent(null);

    List<Student> studentFromCity = students.getStudentsByCity("Ковров");
    assertEquals(0, studentFromCity.size());
  }

  @Test
  @DisplayName("Получение студента по городу")
  void shouldGetStudentsByCity() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Илья", "Москва"));
    students.addStudent(new Student("Марина", "Санкт-Петербург"));
    students.addStudent(new Student("Костя", "Москва"));
    List<Student> studentsFromMoscow = students.getStudentsByCity("Москва");
    assertEquals(2, studentsFromMoscow.size());
  }

  @Test
  @DisplayName("Получение студента по городу")
  void shouldGetEmptyStudentList() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Илья", "Москва"));
    students.addStudent(new Student("Марина", "Санкт-Петербург"));
    students.addStudent(new Student("Костя", "Москва"));
    List<Student> studentsFromMoscow = students.getStudentsByCity("Ковров");
    assertEquals(0, studentsFromMoscow.size());
  }
}
