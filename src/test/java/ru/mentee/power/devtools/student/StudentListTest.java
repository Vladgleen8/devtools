package ru.mentee.power.devtools.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  @DisplayName("Вернутся именно студенты указанного города")
  void shouldReturnExactlyStudentsFromCity() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Илья", "Москва"));
    students.addStudent(new Student("Марина", "Санкт-Петербург"));
    students.addStudent(new Student("Костя", "Москва"));

    List<Student> fromMoscow = students.getStudentsByCity("Москва");

    assertEquals(2, fromMoscow.size());
    assertTrue(fromMoscow.contains(new Student("Илья", "Москва")));
    assertTrue(fromMoscow.contains(new Student("Костя", "Москва")));
    assertTrue(fromMoscow.stream().allMatch(s -> s.city().equals("Москва")));
  }

  @Test
  @DisplayName("Несколько студентов в одном городе сохраняются все")
  void shouldKeepAllStudentsFromSameCity() {
    StudentList students = new StudentList();
    Student ilya = new Student("Илья", "Ковров");
    Student petya = new Student("Пётр", "Ковров");
    Student maria = new Student("Мария", "Москва");

    students.addStudent(ilya);
    students.addStudent(petya);
    students.addStudent(maria);

    List<Student> fromKovrov = students.getStudentsByCity("Ковров");

    assertEquals(2, fromKovrov.size());
    assertTrue(fromKovrov.contains(ilya));
    assertTrue(fromKovrov.contains(petya));
    assertFalse(fromKovrov.contains(maria));
  }
}
