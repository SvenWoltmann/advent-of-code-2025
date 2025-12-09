package eu.happycoders.adventofcode2025.day4;

import eu.happycoders.adventofcode2025.common.Position;

import java.util.List;

final class PrintingDepartment {
  private PrintingDepartment() {
  }

  static long solve(List<String> input, boolean repeatUntilNoMore) {
    Rolls rolls = RollsParser.parse(input);

    int removableRollsCount = 0;

    while (true) {
      List<Position> accessibleRolls = rolls.findAccessibleRolls();
      rolls.remove(accessibleRolls);
      removableRollsCount += accessibleRolls.size();

      if (!repeatUntilNoMore || accessibleRolls.isEmpty()) {
        break;
      }
    }

    return removableRollsCount;
  }
}
