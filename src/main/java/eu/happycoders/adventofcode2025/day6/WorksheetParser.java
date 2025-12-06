package eu.happycoders.adventofcode2025.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

final class WorksheetParser {

  private static final Pattern PATTERN = Pattern.compile("\\s+");

  private WorksheetParser() {
  }

  static List<Problem> parseWorksheet(List<String> lines, boolean numbersInColumns) {
    List<Problem> problems = new ArrayList<>();

    String[] operators = PATTERN.split(lines.getLast().strip());
    for (int i = 0; i < operators.length; i++) {
      problems.add(new Problem(operators[i]));
    }

    if (numbersInColumns) {
      readNumbersInColumns(lines, problems);
    } else {
      readNumbersInRows(lines, problems);
    }

    return problems;
  }

  private static void readNumbersInColumns(List<String> lines, List<Problem> problems) {
    int columnCount = lines.getFirst().length();
    int problemIndex = 0;

    for (int column = 0; column < columnCount; column++) {
      long number = readNumberInColumn(lines, column);
      if (number != 0) {
        problems.get(problemIndex).addNumber(number);
      } else { // separator column
        problemIndex++;
      }
    }
  }

  private static long readNumberInColumn(List<String> lines, int column) {
    long number = 0;

    for (int row = 0; row < lines.size() - 1; row++) {
      char digit = lines.get(row).charAt(column);
      if (digit != ' ') {
        number = number * 10 + (digit - '0');
      }
    }

    return number;
  }

  private static void readNumbersInRows(List<String> lines, List<Problem> problems) {
    int problemCount = problems.size();

    for (int row = 0; row < lines.size() - 1; row++) {
      String line = lines.get(row);
      String[] numbers = PATTERN.split(line.strip());

      for (int column = 0; column < problemCount; column++) {
        problems.get(column).addNumber(Long.parseLong(numbers[column]));
      }
    }
  }
}
