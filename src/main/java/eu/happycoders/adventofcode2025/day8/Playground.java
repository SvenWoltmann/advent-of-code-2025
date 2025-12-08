package eu.happycoders.adventofcode2025.day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

final class Playground {
  private Playground() {
  }

  static long solvePart1(List<String> input, int iterations) {
    List<Point3D> points = input.stream().map(Point3D::parse).toList();
    List<Point3DPairWithDistance> pairs = computePairsWithDistance(points);
    pairs.sort(Comparator.comparing(Point3DPairWithDistance::distance));

    CircuitSet circuits = new CircuitSet(points);

    for (int i = 0; i < iterations; i++) {
      Point3DPairWithDistance pair = pairs.get(i);
      circuits.add(pair);
    }

    List<Set<Point3D>> threeLargest = circuits.getThreeLargest();

    return threeLargest.stream().mapToInt(Set::size).reduce(1, (a, b) -> a * b);
  }

  static long solvePart2(List<String> input) {
    List<Point3D> points = input.stream().map(Point3D::parse).toList();
    List<Point3DPairWithDistance> pairs = computePairsWithDistance(points);
    pairs.sort(Comparator.comparing(Point3DPairWithDistance::distance));

    CircuitSet circuits = new CircuitSet(points);

    for (int i = 0; ; i++) {
      Point3DPairWithDistance pair = pairs.get(i);
      circuits.add(pair);

      if (circuits.size() == 1) {
        return pair.first().x() * pair.second().x();
      }
    }
  }

  private static List<Point3DPairWithDistance> computePairsWithDistance(List<Point3D> points) {
    int numberOfPoints = points.size();
    List<Point3DPairWithDistance> pairs = new ArrayList<>();

    for (int i = 0; i < numberOfPoints; i++) {
      Point3D first = points.get(i);

      for (int j = i + 1; j < numberOfPoints; j++) {
        Point3D second = points.get(j);
        pairs.add(new Point3DPairWithDistance(first, second, first.distanceTo(second)));
      }
    }

    return pairs;
  }
}
