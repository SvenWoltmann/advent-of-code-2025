package eu.happycoders.adventofcode2025.day10;

import java.util.List;

final class Factory {
  private Factory() {
  }

  static long solvePart1(List<String> input) {
    return input.stream()
        .map(Machine::parse)
        .mapToInt(Machine::solvePart1)
        .sum();
  }
}