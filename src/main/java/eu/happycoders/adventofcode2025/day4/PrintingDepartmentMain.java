package eu.happycoders.adventofcode2025.day4;


import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class PrintingDepartmentMain {
  private PrintingDepartmentMain() {
  }

  static void main() {
    List<String> input = readInput("day4/input.txt");
    IO.println("Day 4, part 1 solution = " + PrintingDepartment.solve(input, false));
    IO.println("Day 4, part 2 solution = " + PrintingDepartment.solve(input, true));
  }
}
