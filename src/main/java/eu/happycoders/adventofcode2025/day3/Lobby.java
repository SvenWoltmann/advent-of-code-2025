package eu.happycoders.adventofcode2025.day3;

import java.util.List;

final class Lobby {
  private Lobby() {
  }

  static long solve(List<String> input, int batteriesPerBank) {
    return input.stream()
        .mapToLong(bank -> findMaxJoltage(bank, batteriesPerBank))
        .sum();
  }

  private static long findMaxJoltage(String bank, int batteries) {
    long maxJoltage = 0;
    int startIndex = 0;

    for (int remainingBatteries = batteries; remainingBatteries > 0; remainingBatteries--) {
      MaxJoltageBattery maxJoltageBattery =
          findFirstMaxJoltageBattery(bank, startIndex, remainingBatteries);

      maxJoltage = maxJoltage * 10 + maxJoltageBattery.joltage();
      startIndex = maxJoltageBattery.index() + 1;
    }

    return maxJoltage;
  }

  private static MaxJoltageBattery findFirstMaxJoltageBattery(String bank,
                                                              int startIndex,
                                                              int remainingBatteries) {
    int maxJoltage = 0;
    int maxJoltageFirstIndex = 0;

    for (int i = startIndex; i <= bank.length() - remainingBatteries; i++) {
      byte batteryJoltage = (byte) (bank.charAt(i) - '0');
      if (batteryJoltage > maxJoltage) {
        maxJoltage = batteryJoltage;
        maxJoltageFirstIndex = i;
        
        if (batteryJoltage == 9) {
          break; // It can't get any higher
        }
      }
    }

    return new MaxJoltageBattery(maxJoltage, maxJoltageFirstIndex);
  }

  private record MaxJoltageBattery(int joltage, int index) {
  }
}
