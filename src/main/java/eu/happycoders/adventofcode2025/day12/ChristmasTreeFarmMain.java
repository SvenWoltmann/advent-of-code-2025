package eu.happycoders.adventofcode2025.day12;

import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class ChristmasTreeFarmMain {
  private ChristmasTreeFarmMain() {
  }

  static void main() {
    List<String> input = readInput("day12/input.txt");
    IO.println("Day 12 solution = " + ChristmasTreeFarm.solve(input));
  }
}
