package eu.happycoders.adventofcode2025.day9;

import eu.happycoders.adventofcode2025.common.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class PositionsCompressor {
  private PositionsCompressor() {
  }

  static List<CompressedPosition> compress(List<Position> positions) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    for (Position position : positions) {
      rows.add(position.row());
      cols.add(position.col());
    }

    Map<Integer, Integer> rowIndices = getIndexMap(rows);
    Map<Integer, Integer> colIndices = getIndexMap(cols);

    return positions.stream()
        .map(position -> new CompressedPosition(
            position.row(), position.col(),
            rowIndices.get(position.row()), colIndices.get(position.col())))
        .toList();
  }

  private static Map<Integer, Integer> getIndexMap(Set<Integer> cols) {
    List<Integer> sorted = new ArrayList<>(cols);
    Collections.sort(sorted);

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < sorted.size(); i++) {
      indexMap.put(sorted.get(i), i);
    }

    return indexMap;
  }
}
