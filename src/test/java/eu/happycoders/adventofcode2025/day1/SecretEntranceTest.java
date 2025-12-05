package eu.happycoders.adventofcode2025.day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SecretEntranceTest {

  private static final List<String> INPUT =
      List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82");

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    int solution = SecretEntrance.solve(INPUT, false);
    assertThat(solution).isEqualTo(3);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    int solution = SecretEntrance.solve(INPUT, true);
    assertThat(solution).isEqualTo(6);
  }
}
