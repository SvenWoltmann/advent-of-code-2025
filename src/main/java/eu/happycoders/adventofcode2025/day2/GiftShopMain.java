package eu.happycoders.adventofcode2025.day2;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class GiftShopMain {
  private GiftShopMain() {
  }

  static void main() {
    String input = readInput("day2/input.txt").getFirst();
    IO.println("Day 2, part 1 solution = " + GiftShop.solve(input, 2));
    IO.println("Day 2, part 2 solution = " + GiftShop.solve(input, Integer.MAX_VALUE));
  }
}
