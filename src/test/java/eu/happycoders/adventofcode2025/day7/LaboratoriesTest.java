package eu.happycoders.adventofcode2025.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LaboratoriesTest {
  private static final List<String> INPUT = List.of(
      ".......S.......",
      "...............",
      ".......^.......",
      "...............",
      "......^.^......",
      "...............",
      ".....^.^.^.....",
      "...............",
      "....^.^...^....",
      "...............",
      "...^.^...^.^...",
      "...............",
      "..^...^.....^..",
      "...............",
      ".^.^.^.^.^...^.",
      "...............");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Laboratories.solve(INPUT, false);
    assertThat(solution).isEqualTo(21);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = Laboratories.solve(INPUT, true);
    assertThat(solution).isEqualTo(40);
  }
}