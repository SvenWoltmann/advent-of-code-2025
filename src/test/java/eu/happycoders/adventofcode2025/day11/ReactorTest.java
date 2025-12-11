package eu.happycoders.adventofcode2025.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReactorTest {
  private static final List<String> INPUT_PART_1 = List.of(
      "aaa: you hhh",
      "you: bbb ccc",
      "bbb: ddd eee",
      "ccc: ddd eee fff",
      "ddd: ggg",
      "eee: out",
      "fff: out",
      "ggg: out",
      "hhh: ccc fff iii",
      "iii: out");

  private static final List<String> INPUT_PART_2 = List.of(
      "svr: aaa bbb",
      "aaa: fft",
      "fft: ccc",
      "bbb: tty",
      "tty: ccc",
      "ccc: ddd eee",
      "ddd: hub",
      "hub: fff",
      "eee: dac",
      "dac: fff",
      "fff: ggg hhh",
      "ggg: out",
      "hhh: out");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Reactor.solvePart1(INPUT_PART_1);
    assertThat(solution).isEqualTo(5);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = Reactor.solvePart2(INPUT_PART_2);
    assertThat(solution).isEqualTo(2);
  }
}