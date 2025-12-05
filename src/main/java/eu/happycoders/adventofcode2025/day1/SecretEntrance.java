package eu.happycoders.adventofcode2025.day1;

import java.util.List;

final class SecretEntrance {
  private SecretEntrance() {
  }

  private static final int STARTING_POSITION = 50;
  private static final int DIAL_SIZE = 100;

  static int solve(List<String> input, boolean countAnyClick) {
    int position = STARTING_POSITION;
    int zeroCount = 0;

    for (String line : input) {
      int rotation = parseRotation(line);
      position += rotation;
      if (countAnyClick) {
        zeroCount += calculateZerosPassed(position, rotation);
      } else if (position % DIAL_SIZE == 0) {
        zeroCount++;
      }
      position = Math.floorMod(position, DIAL_SIZE);
    }

    return zeroCount;
  }

  private static int parseRotation(String s) {
    int multiplicator = s.charAt(0) == 'R' ? 1 : -1;
    return multiplicator * Integer.parseInt(s.substring(1));
  }

  private static int calculateZerosPassed(int position, int rotation) {
    if (rotation > 0) {
      return position / DIAL_SIZE;
    } else {
      // This whole else block could be written as a single line of code:
      // `return (DIAL_SIZE - position) / DIAL_SIZE - (position - rotation == 0 ? 1 : 0);`

      // Here's a more readable version:
      int zerosPassed = (DIAL_SIZE - position) / DIAL_SIZE;

      // If the dial started at zero, that zero would be included in the count --> subtract it
      boolean startedAtZero = position - rotation == 0;
      if (startedAtZero) {
        zerosPassed--;
      }

      return zerosPassed;
    }
  }
}