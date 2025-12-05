package eu.happycoders.adventofcode2025.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RangeSet {
  private final List<Range> disjointRanges = new ArrayList<>();

  public void add(Range range) {
    boolean merged;
    do {
      merged = false;
      for (int i = 0; i < disjointRanges.size(); i++) {
        Range mergedRange = range.tryMergeWith(disjointRanges.get(i));
        if (mergedRange != null) {
          disjointRanges.remove(i);
          range = mergedRange;
          merged = true;
          break;
        }
      }
    } while (merged);

    disjointRanges.add(range);
  }

  public boolean contains(long value) {
    return disjointRanges
        .stream()
        .anyMatch(range -> range.contains(value));
  }

  public Stream<Range> stream() {
    return disjointRanges.stream();
  }
}
