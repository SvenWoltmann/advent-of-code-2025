package eu.happycoders.adventofcode2025.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryTest {
  private static final List<String> INPUT = List.of(
      "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
      "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
      "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Factory.solvePart1(INPUT);
    assertThat(solution).isEqualTo(7);
  }

  // @Test
  // void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
  //   long solution = Factory.solvePart2(INPUT);
  //   assertThat(solution).isEqualTo(33);
  // }
}