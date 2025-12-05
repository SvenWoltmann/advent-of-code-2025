package eu.happycoders.adventofcode2025.day4;

import java.util.List;

final class RollsParser {
  private RollsParser() {
  }

  static Rolls parse(List<String> input) {
    int height = input.size();
    int width = input.getFirst().length();

    boolean[][] grid = new boolean[height][width];

    for (int row = 0; row < height; row++) {
      String line = input.get(row);
      for (int col = 0; col < width; col++) {
        grid[row][col] = line.charAt(col) == '@';
      }
    }

    return new Rolls(grid, width, height);
  }
}
