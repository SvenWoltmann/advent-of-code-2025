package eu.happycoders.adventofcode2025.day7;

import java.util.Arrays;
import java.util.List;

final class Laboratories {
  private Laboratories() {
  }

  static long solve(List<String> input, boolean countTachyons) {
    long[] tachyons = createInitialTachyon(input.getFirst());
    long splitCount = 0;

    for (int i = 1; i < input.size(); i++) {
      String line = input.get(i);
      SplitResult splitResult = split(line, tachyons);
      tachyons = splitResult.tachyons();
      splitCount += splitResult.splitCount();
    }

    if (countTachyons) {
      return Arrays.stream(tachyons).sum();
    } else {
      return splitCount;
    }
  }

  private static long[] createInitialTachyon(String firstLine) {
    int width = firstLine.length();
    long[] tachyons = new long[width];

    int startPosition = firstLine.indexOf('S');
    tachyons[startPosition] = 1;

    return tachyons;
  }

  private static SplitResult split(String line, long[] rowOfTachyons) {
    int width = line.length();
    long[] splitResult = new long[width];
    int splitCount = 0;

    for (int i = 0; i < width; i++) {
      long tachyons = rowOfTachyons[i];
      if (tachyons > 0) {
        if (line.charAt(i) == '^') {
          splitResult[i - 1] += tachyons;
          splitResult[i + 1] += tachyons;
          splitCount++;
        } else {
          splitResult[i] += tachyons;
        }
      }
    }

    return new SplitResult(splitResult, splitCount);
  }

  @SuppressWarnings("squid:S6218") // Using this only as a result, we will never compare two instances
  private record SplitResult(long[] tachyons, int splitCount) {
  }
}
