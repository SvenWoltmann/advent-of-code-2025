package eu.happycoders.adventofcode2025.day6;

import static eu.happycoders.adventofcode2025.day6.WorksheetParser.parseWorksheet;

import java.util.List;

final class TrashCompactor {
  private TrashCompactor() {}

  static long solve(List<String> lines, boolean numbersInColumns) {
    List<Problem> problems = parseWorksheet(lines, numbersInColumns);

    return problems.stream().mapToLong(Problem::solve).sum();
  }
}
