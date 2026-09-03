package eu.happycoders.adventofcode2025.day1;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

import java.util.List;

final class SecretEntranceMain {
  private SecretEntranceMain() {}

  static void main() {
    List<String> input = readInput("day1/input.txt");
    IO.println("Day 1, part 1 solution = " + SecretEntrance.solve(input, false));
    IO.println("Day 1, part 2 solution = " + SecretEntrance.solve(input, true));
  }
}
