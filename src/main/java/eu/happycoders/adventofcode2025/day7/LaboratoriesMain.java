package eu.happycoders.adventofcode2025.day7;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

import java.util.List;

final class LaboratoriesMain {
  private LaboratoriesMain() {}

  static void main() {
    List<String> input = readInput("day7/input.txt");
    IO.println("Day 7, part 1 solution = " + Laboratories.solve(input, false));
    IO.println("Day 7, part 2 solution = " + Laboratories.solve(input, true));
  }
}
