package eu.happycoders.adventofcode2025.day8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CircuitSet {
  private final List<Set<Point3D>> circuits = new ArrayList<>();

  CircuitSet(List<Point3D> points) {
    for (Point3D point : points) {
      Set<Point3D> circuit = new HashSet<>();
      circuit.add(point);
      circuits.add(circuit);
    }
  }

  void add(Point3DPairWithDistance pair) {
    int firstIndex = -1;
    int secondIndex = -1;

    for (int i = 0; i < circuits.size(); i++) {
      Set<Point3D> circuit = circuits.get(i);
      if (circuit.contains(pair.first())) {
        firstIndex = i;
      }
      if (circuit.contains(pair.second())) {
        secondIndex = i;
      }
    }

    // Connect circuits if both are in different ones
    if (firstIndex != secondIndex) {
      circuits.get(firstIndex).addAll(circuits.get(secondIndex));
      circuits.remove(secondIndex);
    }
  }

  List<Set<Point3D>> getThreeLargest() {
    circuits.sort((c1, c2) -> Integer.compare(c2.size(), c1.size()));
    return List.copyOf(circuits.subList(0, 3));
  }

  int size() {
    return circuits.size();
  }
}
