package eu.happycoders.adventofcode2025.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasTreeFarmTest {
  private static final List<String> INPUT = List.of(
      "0:",
      "###",
      "##.",
      "##.",
      "",
      "1:",
      "###",
      "##.",
      ".##",
      "",
      "2:",
      ".##",
      "###",
      "##.",
      "",
      "3:",
      "##.",
      "###",
      "##.",
      "",
      "4:",
      "###",
      "#..",
      "###",
      "",
      "5:",
      "###",
      ".#.",
      "###",
      "",
      "4x4: 0 0 0 0 2 0",
      "12x5: 1 0 1 0 2 2",
      "12x5: 1 0 1 0 3 2");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = ChristmasTreeFarm.solve(INPUT);
    assertThat(solution).isEqualTo(2);
  }
}