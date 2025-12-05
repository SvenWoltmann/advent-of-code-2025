package eu.happycoders.adventofcode2025.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrintingDepartmentTest {
  private static final List<String> INPUT = List.of(
      "..@@.@@@@.",
      "@@@.@.@.@@",
      "@@@@@.@.@@",
      "@.@@@@..@.",
      "@@.@@@@.@@",
      ".@@@@@@@.@",
      ".@.@.@.@@@",
      "@.@@@.@@@@",
      ".@@@@@@@@.",
      "@.@.@@@.@.");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = PrintingDepartment.solve(INPUT, false);
    assertThat(solution).isEqualTo(13);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = PrintingDepartment.solve(INPUT, true);
    assertThat(solution).isEqualTo(43);
  }
}
