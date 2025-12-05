package eu.happycoders.adventofcode2025.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputReaderTest {

  @Test
  void givenAnInputFile_whenReadInput_thenReadsTheLinesIntoAList() {
    List<String> input = InputReader.readInput("input.txt");

    assertThat(input)
        .containsExactly("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82");
  }
}
