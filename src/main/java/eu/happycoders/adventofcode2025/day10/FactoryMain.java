package eu.happycoders.adventofcode2025.day10;

import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class FactoryMain {
  private FactoryMain() {
  }

  static void main() {
    List<String> input = readInput("day10/input.txt");
    IO.println("Day 10, part 1 solution = " + Factory.solvePart1(input));
    // IO.println("Day 10, part 2 solution = " + Factory.solvePart2(input));
  }
}
