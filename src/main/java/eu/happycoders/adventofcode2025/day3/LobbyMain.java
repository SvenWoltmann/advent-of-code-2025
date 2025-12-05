package eu.happycoders.adventofcode2025.day3;

import java.util.List;

import static eu.happycoders.adventofcode2025.common.InputReader.readInput;

final class LobbyMain {
  private LobbyMain() {
  }

  static void main() {
    List<String> input = readInput("day3/input.txt");
    IO.println("Day 3, part 1 solution = " + Lobby.solve(input, 2));
    IO.println("Day 3, part 2 solution = " + Lobby.solve(input, 12));
  }
}
