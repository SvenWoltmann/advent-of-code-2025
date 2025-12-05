package eu.happycoders.adventofcode2025.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LobbyTest {

  private static final List<String> INPUT =
      List.of("987654321111111",
          "811111111111119",
          "234234234234278",
          "818181911112111");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = Lobby.solve(INPUT, 2);
    assertThat(solution).isEqualTo(357);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = Lobby.solve(INPUT, 12);
    assertThat(solution).isEqualTo(3121910778619L);
  }
}
