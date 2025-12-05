package eu.happycoders.adventofcode2025.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CafeteriaTest {
  private static final List<String> INPUT = List.of(
      "3-5",
      "10-14",
      "16-20",
      "12-18",
      "",
      "1",
      "5",
      "8",
      "11",
      "17");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Cafeteria.solvePart1(INPUT);
    assertThat(solution).isEqualTo(3);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = Cafeteria.solvePart2(INPUT);
    assertThat(solution).isEqualTo(14);
  }
}