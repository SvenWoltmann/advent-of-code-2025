package eu.happycoders.adventofcode2025.day4;

import java.util.ArrayList;
import java.util.List;

class Rolls {
  private final boolean[][] grid;
  private final int width;
  private final int height;

  Rolls(boolean[][] grid, int width, int height) {
    this.grid = grid;
    this.width = width;
    this.height = height;
  }

  List<Position> findAccessibleRolls() {
    List<Position> result = new ArrayList<>();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        Position position = new Position(row, col);
        if (hasRollAt(position) && isAccessible(position)) {
          result.add(position);
        }
      }
    }

    return result;
  }


  private boolean hasRollAt(Position position) {
    return grid[position.row()][position.col()];
  }

  private boolean isAccessible(Position position) {
    int row = position.row();
    int col = position.col();

    int adjacentRolls = 0;

    if (hasRollAt(row - 1, col - 1)) adjacentRolls++;
    if (hasRollAt(row - 1, col)) adjacentRolls++;
    if (hasRollAt(row - 1, col + 1)) adjacentRolls++;
    if (hasRollAt(row, col - 1)) adjacentRolls++;
    if (hasRollAt(row, col + 1)) adjacentRolls++;
    if (hasRollAt(row + 1, col - 1)) adjacentRolls++;
    if (hasRollAt(row + 1, col)) adjacentRolls++;
    if (hasRollAt(row + 1, col + 1)) adjacentRolls++;

    return adjacentRolls < 4;
  }

  private boolean hasRollAt(int row, int col) {
    if (row < 0 || row >= height || col < 0 || col >= width) {
      return false;
    }
    return grid[row][col];
  }

  void remove(List<Position> rolls) {
    for (Position roll : rolls) {
      grid[roll.row()][roll.col()] = false;
    }
  }
}
