package eu.happycoders.adventofcode2025.day12;

import java.util.List;

final class ChristmasTreeFarm {
  private ChristmasTreeFarm() {
  }

  static long solve(List<String> lines) {
    PuzzleInput input = PuzzleInput.parse(lines);
    return input.trees().stream()
        .filter(tree -> tree.allPresentsFit(input.presents()))
        .count();
  }
}