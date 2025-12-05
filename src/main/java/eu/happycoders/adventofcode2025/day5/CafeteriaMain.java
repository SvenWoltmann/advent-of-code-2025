package eu.happycoders.adventofcode2025.day5;

import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class CafeteriaMain {
  private CafeteriaMain() {
  }

  static void main() {
    List<String> input = readInput("day5/input.txt");
    IO.println("Day 5, part 1 solution = " + Cafeteria.solvePart1(input));
    IO.println("Day 5, part 2 solution = " + Cafeteria.solvePart2(input));
  }
}
