package eu.happycoders.adventofcode2025.day12;

import java.util.ArrayList;
import java.util.List;

record Present(List<Shape> shapeRotations) {

  static Present parse(List<String> lines) {
    if (lines.getFirst().indexOf(':') == -1) {
      throw new IllegalArgumentException("Expected : in first line of present");
    }
    Shape shape = Shape.parse(lines.subList(1, lines.size()));
    List<Shape> shapeRotations = new ArrayList<>();
    shapeRotations.add(shape);
    addFlipped(shape, shapeRotations);

    // Add rotated shapes
    for (int i = 0; i < 3; i++) {
      shape = shape.rotateRight();
      if (!shapeRotations.contains(shape)) {
        shapeRotations.add(shape);
        addFlipped(shape, shapeRotations);
      }
    }

    return new Present(List.copyOf(shapeRotations));
  }

  private static void addFlipped(Shape shape, List<Shape> shapeRotations) {
    Shape flippedH = shape.flipHorizontally();
    if (!shapeRotations.contains(flippedH)) {
      shapeRotations.add(flippedH);
    }
    Shape flippedV = shape.flipVertically();
    if (!shapeRotations.contains(flippedV)) {
      shapeRotations.add(flippedV);
    }
  }
}
