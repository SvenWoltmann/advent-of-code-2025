package eu.happycoders.adventofcode2025.day12;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("java:S6218") // We don't need a `toString` method
record Shape(int width, int height, boolean[][] parts) {

  static Shape parse(List<String> lines) {
    int height = lines.size();
    int width = lines.getFirst().length();

    boolean[][] parts = new boolean[height][width];
    for (int row = 0; row < height; row++) {
      String line = lines.get(row);
      for (int col = 0; col < width; col++) {
        parts[row][col] = line.charAt(col) == '#';
      }
    }
    return new Shape(width, height, parts);
  }

  Shape rotateRight() {
    int newWidth = height;
    int newHeight = width;

    boolean[][] rotated = new boolean[newHeight][newWidth];
    for (int row = 0; row < newHeight; row++) {
      for (int col = 0; col < newWidth; col++) {
        rotated[col][newHeight - row - 1] = parts[row][col];
      }
    }
    return new Shape(newWidth, newHeight, rotated);
  }

  Shape flipHorizontally() {
    boolean[][] flipped = new boolean[parts.length][parts[0].length];
    for (int row = 0; row < parts.length; row++) {
      for (int col = 0; col < parts[row].length; col++) {
        flipped[row][parts[row].length - col - 1] = parts[row][col];
      }
    }
    return new Shape(width, height, flipped);
  }

  Shape flipVertically() {
    boolean[][] flipped = new boolean[parts.length][parts[0].length];
    for (int row = 0; row < parts.length; row++) {
      System.arraycopy(parts[row], 0, flipped[parts.length - row - 1], 0, parts[row].length);
    }
    return new Shape(width, height, flipped);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Shape shape)) return false;
    return Objects.deepEquals(parts, shape.parts);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(parts);
  }

  int pixelCount() {
    int pixelCount = 0;
    for (boolean[] row : parts) {
      for (boolean pixel : row) {
        if (pixel) pixelCount++;
      }
    }
    return pixelCount;
  }
}
