package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.data.Offset.offset;
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
  void shouldCalculateTotalProgress_WhenMultipleMentees() {
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
    assertThat(mentees).extracting(Mentee::name).containsExactly("Иван", "Мария", "Пётр");

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

  @Test
  void shouldCalculateProgress() {
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 6, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 6, 12)
    };
    ProgressTracker tracker = new ProgressTracker();
    double actualProgress = tracker.averageProgressPercent(mentees);
    double expectedProgress = 50.0;
    assertThat(actualProgress)
        .isEqualTo(expectedProgress);
  }

  @Test
  @DisplayName("Средний процент для некруглых значений")
  void shouldCalculateAverageProgressPercent_whenValuesAreNotRound() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 12),
        new Mentee("Мария", "СПб", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };
    double result = tracker.averageProgressPercent(mentees);
    assertThat(result).isCloseTo(69.444, offset(0.01));
  }

  @Test
  @DisplayName("Ислюкчение при пустом массиве")
  void shouldThrowException_WhenMenteesEmptyArray() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {};
    assertThatThrownBy(() -> tracker.averageProgressPercent(mentees)).isInstanceOf(IllegalArgumentException.class).hasMessage("Пустой список mentee");
  }

  @Test
  @DisplayName("Средний процент в границах (40, 50) при неполном прохождении")
  void shouldReturnAverageProgressPercentWithinBounds_whenAtLeastOneMenteeNotCompleted() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 5, 12)
    };

    double result = tracker.averageProgressPercent(mentees);

    assertThat(result)
        .isGreaterThan(40)
        .isLessThanOrEqualTo(50);
  }
}