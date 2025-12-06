package eu.happycoders.adventofcode2025.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrashCompactorTest {
  private static final List<String> INPUT = List.of(
      "123 328  51 64 ",
      " 45 64  387 23 ",
      "  6 98  215 314",
      "*   +   *   +  ");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = TrashCompactor.solve(INPUT, false);
    assertThat(solution).isEqualTo(4277556);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = TrashCompactor.solve(INPUT, true);
    assertThat(solution).isEqualTo(3263827);
  }
}