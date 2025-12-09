package eu.happycoders.adventofcode2025.day9;

import eu.happycoders.adventofcode2025.common.Position;

import java.util.LinkedHashSet;
import java.util.List;

class TileFloor {
  private static final byte BORDER = 1;
  private static final byte OUTSIDE = 2;

  private final byte[][] borderMatrix;

  private TileFloor(byte[][] borderMatrix) {
    this.borderMatrix = borderMatrix;
  }

  static TileFloor compute(List<CompressedPosition> compressedRedTiles) {
    byte[][] borderMatrix = drawBorder(compressedRedTiles);
    floodFill(borderMatrix, 0, 0);
    return new TileFloor(borderMatrix);
  }

  private static byte[][] drawBorder(List<CompressedPosition> redTiles) {
    int maxCol = 0;
    int maxRow = 0;

    for (CompressedPosition redTile : redTiles) {
      if (redTile.compressedCol() > maxCol) {
        maxCol = redTile.compressedCol();
      }
      if (redTile.compressedRow() > maxRow) {
        maxRow = redTile.compressedRow();
      }
    }

    byte[][] result = new byte[maxRow + 1 + 2][]; // Add 2 for margin (so we can flood-fill the outside)
    for (int row = 0; row < maxRow + 1 + 2; row++) {
      result[row] = new byte[maxCol + 1 + 2]; // Add 2 for margin (so we can flood-fill the outside)
    }

    CompressedPosition previousRedTile = null;
    for (CompressedPosition redTile : redTiles) {
      addRedTile(redTile, previousRedTile, result);
      previousRedTile = redTile;
    }
    // Add the first red tile to close the loop
    addRedTile(redTiles.getFirst(), previousRedTile, result);
    return result;
  }

  private static void addRedTile(CompressedPosition redTile, CompressedPosition previousRedTile, byte[][] result) {
    int col = redTile.compressedCol();
    int row = redTile.compressedRow();

    if (previousRedTile != null) {
      int previousCol = previousRedTile.compressedCol();
      int previousRow = previousRedTile.compressedRow();
      if (col == previousCol) {
        walkCol(previousRow, row, col, result);
      } else if (row == previousRow) {
        walkRow(previousCol, col, row, result);
      } else {
        throw new IllegalArgumentException();
      }
    }
  }

  private static void walkRow(int previousCol, int col, int row, byte[][] result) {
    if (col > previousCol) {
      for (int c = previousCol + 1; c <= col; c++) {
        result[row + 1][c + 1] = BORDER;
      }
    } else {
      for (int c = previousCol - 1; c >= col; c--) {
        result[row + 1][c + 1] = BORDER;
      }
    }
  }

  private static void walkCol(int previousRow, int row, int col, byte[][] result) {
    if (row > previousRow) {
      for (int r = previousRow + 1; r <= row; r++) {
        result[r + 1][col + 1] = BORDER;
      }
    } else {
      for (int r = previousRow - 1; r >= row; r--) {
        result[r + 1][col + 1] = BORDER;
      }
    }
  }

  private static void floodFill(byte[][] borderMatrix, int startRow, int startCol) {
    int width = borderMatrix[0].length;

    LinkedHashSet<Position> queue = new LinkedHashSet<>();
    queue.add(new Position(startRow, startCol));
    borderMatrix[startRow][startCol] = OUTSIDE;

    while (!queue.isEmpty()) {
      Position position = queue.removeFirst();

      if (position.col() < width - 1 && borderMatrix[position.row()][position.col() + 1] == 0) {
        borderMatrix[position.row()][position.col() + 1] = OUTSIDE;
        queue.add(new Position(position.row(), position.col() + 1));
      }
      if (position.col() > 0 && borderMatrix[position.row()][position.col() - 1] == 0) {
        borderMatrix[position.row()][position.col() - 1] = OUTSIDE;
        queue.add(new Position(position.row(), position.col() - 1));
      }
      if (position.row() < width - 1 && borderMatrix[position.row() + 1][position.col()] == 0) {
        borderMatrix[position.row() + 1][position.col()] = OUTSIDE;
        queue.add(new Position(position.row() + 1, position.col()));
      }
      if (position.row() > 0 && borderMatrix[position.row() - 1][position.col()] == 0) {
        borderMatrix[position.row() - 1][position.col()] = OUTSIDE;
        queue.add(new Position(position.row() - 1, position.col()));
      }
    }
  }

  boolean doesNotTouchOutside(CompressedPosition first, CompressedPosition second) {
    int minRow = Math.min(first.compressedRow(), second.compressedRow());
    int maxRow = Math.max(first.compressedRow(), second.compressedRow());
    int minCol = Math.min(first.compressedCol(), second.compressedCol());
    int maxCol = Math.max(first.compressedCol(), second.compressedCol());

    // Brute-force check if it touches the outside
    for (int row = minRow; row <= maxRow; row++) {
      for (int col = minCol; col <= maxCol; col++) {
        if (borderMatrix[row + 1][col + 1] == OUTSIDE) {
          return false;
        }
      }
    }

    return true;
  }
}
