package ru.mentee.power.devtools.progress;

public class ProgressTracker {
  public String calculateTotalProgress(Mentee[] mentees) {
    int completedLessons = 0;
    int totalLessons = 0;
    int index = 0;

    while (index < mentees.length) {
      completedLessons += mentees[index].completedLessons();
      totalLessons += mentees[index].totalLessons();
      index++;
    }

    return "Суммарно: пройдено %d из %d уроков, осталось %d уроков".formatted(completedLessons,
        totalLessons, totalLessons - completedLessons);
  }

  /**
   * Средний процент прохождения по всем mentee.
   *
   * @throws IllegalArgumentException если массив пуст
   */
  public double averageProgressPercent(Mentee[] mentees) {
    if (mentees.length == 0) {
      throw new IllegalArgumentException("Пустой список mentee");
    }
    int index = 0;
    double averagePercent = 0;
    while (index < mentees.length) {
      Mentee mentee = mentees[index];
      double menteeProgress = mentee.completedLessons() * 100.0 / mentee.totalLessons();
      averagePercent += menteeProgress;
      index++;
    }
    return averagePercent / index;
  }

  public static void main(String[] args) {
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    System.out.println(new ProgressTracker().calculateTotalProgress(mentees));
  }
}
