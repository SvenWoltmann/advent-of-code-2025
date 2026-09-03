package eu.happycoders.adventofcode2025.day11;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

import java.util.List;

final class ReactorMain {
  private ReactorMain() {}

  static void main() {
    List<String> input = readInput("day11/input.txt");
    IO.println("Day 11, part 1 solution = " + Reactor.solvePart1(input));
    IO.println("Day 11, part 2 solution = " + Reactor.solvePart2(input));
  }
}
