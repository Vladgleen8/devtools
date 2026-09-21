package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {
  @Test
  void checkIsReadyForSprint() {
    MenteeProgress progress = new MenteeProgress("Vladislav Medvedev", 2, 3);
    assertTrue(progress.readyForSprint());
  }

  @Test
  void checkIsNotReadyForSprint() {
    MenteeProgress progress = new MenteeProgress("Vladislav Medvedev", 2, 2);
    assertFalse(progress.readyForSprint());
  }

  @Test
  void checkIsSummaryCorrect() {
    MenteeProgress progress = new MenteeProgress("Vladislav Medvedev", 1, 8);
    String expectedSummary = "Sprint 1 → Vladislav Medvedev: planned 8 h";
    String actualSummary = progress.summary();
    assertEquals(expectedSummary, actualSummary);
  }

  @Test
  void summaryShouldHandleNullName() {
    MenteeProgress progress = new MenteeProgress(null, 1, 5);
    String expected = "Sprint 1 → null: planned 5 h";
    assertEquals(expected, progress.summary());
  }

  @Test
  void summaryShouldContainEmptyNameWithoutChanges() {
    MenteeProgress progress = new MenteeProgress("", 1, 5);
    String expected = "Sprint 1 → : planned 5 h";
    assertEquals(expected, progress.summary());
  }
}