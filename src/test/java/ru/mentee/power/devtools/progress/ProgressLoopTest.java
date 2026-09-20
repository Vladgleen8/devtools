package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

  @Test
  @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
  void shouldCalculateTotalProgressWhenMultipleMentees() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 25 из 36 уроков")
        .contains("осталось 11 уроков");
  }

  @Test
  @DisplayName("Все mentee завершили курс — осталось 0")
  void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 24 из 24 уроков")
        .contains("осталось 0 уроков");
  }

  @Test
  @DisplayName("У менти 0 уроков доступно")
  void shouldThrowExceptionWhenMenteeHasZeroTotalLessons() {
    assertThrows(IllegalArgumentException.class, () -> new Mentee("Иван", "Москва", "Backend", 0,
        0));
  }

  @Test
  @DisplayName("У менти выполнено больше уроков чем доступно")
  void shouldThrowExceptionWhenMenteeHasLessTotalLessonsThanExecuted() {
    assertThrows(IllegalArgumentException.class, () -> new Mentee("Иван", "Москва", "Backend", 12
        , 0));
  }

  @Test
  @DisplayName("Менти переданы корректные значения")
  void shouldNotThrowExceptionWhenMenteeHasCorrectFields() {
    assertDoesNotThrow(() -> {
      new Mentee("Иван", "Москва", "Backend", 12, 12);
      new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12);
    });
  }

  @Test
  @DisplayName("Пустой массив — суммарный прогресс равен нулю")
  void shouldCalculateZeroProgressWhenMenteesArrayIsEmpty() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {};

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 0 из 0 уроков")
        .contains("осталось 0 уроков");
  }

  @Test
  @DisplayName("Один mentee — прогресс считается корректно")
  void shouldCalculateProgressWhenSingleMentee() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 5 из 12 уроков")
        .contains("осталось 7 уроков");
  }

  @Test
  @DisplayName("Отрицательное количество выполненных уроков")
  void shouldThrowExceptionWhenCompletedLessonsIsNegative() {
    assertThrows(IllegalArgumentException.class,
        () -> new Mentee("Иван", "Москва", "Backend", -1, 12));
  }

  @Test
  @DisplayName("Выполнено больше, чем доступно")
  void shouldThrowExceptionWhenCompletedMoreThanTotal() {
    assertThrows(IllegalArgumentException.class,
        () -> new Mentee("Иван", "Москва", "Backend", 13, 12));
  }

  @Test
  @DisplayName("Отрицательное количество доступных уроков")
  void shouldThrowExceptionWhenTotalLessonsIsNegative() {
    assertThrows(IllegalArgumentException.class,
        () -> new Mentee("Иван", "Москва", "Backend", 0, -5));
  }

  @Test
  @DisplayName("main выполняется без исключений")
  void shouldRunMainWithoutExceptions() {
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(OutputStream.nullOutputStream()));
    try {
      assertDoesNotThrow(() -> ProgressTracker.main(new String[0]));
    } finally {
      System.setOut(originalOut);
    }
  }
}