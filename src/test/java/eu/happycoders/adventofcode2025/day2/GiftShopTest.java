package eu.happycoders.adventofcode2025.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GiftShopTest {

  private static final String INPUT =
      "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,"
          + "1698522-1698528,446443-446449,38593856-38593862,565653-565659,"
          + "824824821-824824827,2121212118-2121212124";

  @Test
  void givenInput_whenSolvePart1_thenReturnsCorrectResult() {
    long solution = GiftShop.solve(INPUT, 2);
    assertThat(solution).isEqualTo(1227775554);
  }

  @Test
  void givenInput_whenSolvePart2_thenReturnsCorrectResult() {
    long solution = GiftShop.solve(INPUT, Integer.MAX_VALUE);
    assertThat(solution).isEqualTo(4174379265L);
  }
}
