package eu.happycoders.adventofcode2025.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTheaterTest {
  private static final List<String> INPUT = List.of(
      "7,1",
      "11,1",
      "11,7",
      "9,7",
      "9,5",
      "2,5",
      "2,3",
      "7,3");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = MovieTheater.solve(INPUT, false);
    assertThat(solution).isEqualTo(50);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = MovieTheater.solve(INPUT, true);
    assertThat(solution).isEqualTo(24);
  }
}