package eu.happycoders.adventofcode2025.day6;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

import java.util.List;

final class TrashCompactorMain {
  private TrashCompactorMain() {}

  static void main() {
    List<String> input = readInput("day6/input.txt");
    IO.println("Day 6, part 1 solution = " + TrashCompactor.solve(input, false));
    IO.println("Day 6, part 2 solution = " + TrashCompactor.solve(input, true));
  }
}
