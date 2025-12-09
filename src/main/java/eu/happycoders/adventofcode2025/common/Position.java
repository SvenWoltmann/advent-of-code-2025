package eu.happycoders.adventofcode2025.common;

public record Position(int row, int col) {
  public static Position parse(String input) {
    String[] parts = input.split(",");
    int col = Integer.parseInt(parts[0]);
    int row = Integer.parseInt(parts[1]);
    return new Position(row, col);
  }
}
