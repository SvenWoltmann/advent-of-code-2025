package eu.happycoders.adventofcode2025.day8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlaygroundTest {
  private static final List<String> INPUT = List.of(
      "162,817,812",
      "57,618,57",
      "906,360,560",
      "592,479,940",
      "352,342,300",
      "466,668,158",
      "542,29,236",
      "431,825,988",
      "739,650,466",
      "52,470,668",
      "216,146,977",
      "819,987,18",
      "117,168,530",
      "805,96,715",
      "346,949,466",
      "970,615,88",
      "941,993,340",
      "862,61,35",
      "984,92,344",
      "425,690,689");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Playground.solvePart1(INPUT, 10);
    assertThat(solution).isEqualTo(40);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = Playground.solvePart2(INPUT);
    assertThat(solution).isEqualTo(25272);
  }
}