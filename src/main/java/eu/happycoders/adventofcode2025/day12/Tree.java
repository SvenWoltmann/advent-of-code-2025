package eu.happycoders.adventofcode2025.day12;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S6218") // We don't need `equals`, `hashCode`, or `toString`
record Tree(int width, int height, int[] presentCounts) {

  static Tree parse(String line) {
    int colonPos = line.indexOf(':');

    String size = line.substring(0, colonPos);
    String[] widthAndHeight = size.split("x");
    int width = Integer.parseInt(widthAndHeight[0]);
    int height = Integer.parseInt(widthAndHeight[1]);

    String[] presentCountStrings = line.substring(colonPos + 2).split(" ");
    int[] presentCounts = new int[presentCountStrings.length];
    for (int i = 0; i < presentCountStrings.length; i++) {
      presentCounts[i] = Integer.parseInt(presentCountStrings[i]);
    }

    return new Tree(width, height, presentCounts);
  }

  boolean allPresentsFit(List<Present> presents) {
    int pixelsAvailable = width * height;
    int pixelsRequired = 0;

    int maxWidth = 0;
    int maxHeight = 0;

    List<Present> presentsToFit = new ArrayList<>();
    for (int presentIndex = 0; presentIndex < presentCounts.length; presentIndex++) {
      int presentCount = presentCounts[presentIndex];
      for (int i = 0; i < presentCount; i++) {
        Present present = presents.get(presentIndex);
        presentsToFit.add(present);
        Shape shape = present.shapeRotations().getFirst();
        pixelsRequired += shape.pixelCount();
        if (shape.width() > maxWidth) maxWidth = shape.width();
        if (shape.height() > maxHeight) maxHeight = shape.height();
      }
    }

    if (pixelsRequired > pixelsAvailable) {
      return false;
    }

    int numberOfPresentsThatWouldFitRegardlessOfTheirShape = (width / maxWidth) * (height / maxHeight);
    if (presentsToFit.size() <= numberOfPresentsThatWouldFitRegardlessOfTheirShape) {
      return true;
    }

    // This code is actually never called for the puzzle input - only for the tests
    boolean[][] area = new boolean[height][width];
    return place(area, presentsToFit, 0);
  }

  private boolean place(boolean[][] area, List<Present> presents, int presentIndex) {
    Present present = presents.get(presentIndex);
    for (Shape shape : present.shapeRotations()) {
      boolean allFit = place(area, shape, presents, presentIndex);
      if (allFit) {
        return true;
      }
    }
    return false;
  }

  private boolean place(boolean[][] area, Shape shape, List<Present> presents, int presentIndex) {
    int maxCol = width - shape.width();
    int maxRow = height - shape.height();

    for (int row = 0; row <= maxRow; row++) {
      for (int col = 0; col <= maxCol; col++) {
        if (fitsAtPosition(area, shape, col, row)) {
          area = area.clone();

          boolean[][] newArea = new boolean[height][];
          for (int i = 0; i < height; i++) {
            newArea[i] = area[i].clone();
          }

          drawAtPosition(newArea, shape, col, row);

          presentIndex++;
          if (presentIndex == presents.size()) {
            return true;
          } else {
            return place(newArea, presents, presentIndex);
          }
        }
      }
    }
    return false;
  }

  private boolean fitsAtPosition(boolean[][] area, Shape shape, int startCol, int startRow) {
    for (int row = 0; row < shape.height(); row++) {
      for (int col = 0; col < shape.width(); col++) {
        if (area[startRow + row][startCol + col] && shape.parts()[row][col]) {
          return false;
        }
      }
    }
    return true;
  }

  private void drawAtPosition(boolean[][] area, Shape shape, int startCol, int startRow) {
    for (int row = 0; row < shape.height(); row++) {
      for (int col = 0; col < shape.width(); col++) {
        if (shape.parts()[row][col]) {
          area[startRow + row][startCol + col] = true;
        }
      }
    }
  }
}
