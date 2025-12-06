package eu.happycoders.adventofcode2025.day6;

import java.util.ArrayList;
import java.util.List;

class Problem {
  private final List<Long> numbers = new ArrayList<>();
  private final String operator;

  Problem(String operator) {
    this.operator = operator;
  }

  void addNumber(long number) {
    numbers.add(number);
  }

  long solve() {
    return switch (operator) {
      case "+" -> numbers.stream().mapToLong(Long::valueOf).sum();
      case "*" -> numbers.stream().mapToLong(Long::valueOf).reduce(1, (a, b) -> a * b);
      default -> throw new IllegalArgumentException("Unknown operator: " + operator);
    };
  }
}
