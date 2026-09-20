package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}