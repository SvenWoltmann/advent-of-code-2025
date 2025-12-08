package eu.happycoders.adventofcode2025.day8;

import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class PlaygroundMain {
  private PlaygroundMain() {
  }

  static void main() {
    List<String> input = readInput("day8/input.txt");
    IO.println("Day 8, part 1 solution = " + Playground.solvePart1(input, 1000));
    IO.println("Day 8, part 2 solution = " + Playground.solvePart2(input));
  }
}
