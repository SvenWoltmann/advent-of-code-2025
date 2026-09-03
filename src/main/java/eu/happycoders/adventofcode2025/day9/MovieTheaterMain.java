package eu.happycoders.adventofcode2025.day9;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

import java.util.List;

final class MovieTheaterMain {
  private MovieTheaterMain() {}

  static void main() {
    List<String> input = readInput("day9/input.txt");
    IO.println("Day 9, part 1 solution = " + MovieTheater.solve(input, false));
    IO.println("Day 9, part 2 solution = " + MovieTheater.solve(input, true));
  }
}
