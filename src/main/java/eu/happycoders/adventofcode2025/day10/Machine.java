package eu.happycoders.adventofcode2025.day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

final class Machine {
  private final Lights lightsGoal;
  private final List<ButtonWiring> buttonWirings;
  private final int[] joltageGoal;

  private Machine(Lights lightsGoal, List<ButtonWiring> buttonWirings, int[] joltageGoal) {
    this.lightsGoal = lightsGoal;
    this.buttonWirings = buttonWirings;
    this.joltageGoal = joltageGoal;
  }

  static Machine parse(String line) {
    String[] tokens = line.split(" ");
    Lights lightsGoal = Lights.parse(tokens[0]);

    List<ButtonWiring> buttonWirings = new ArrayList<>();
    for (int i = 1; i < tokens.length - 1; i++) {
      buttonWirings.add(ButtonWiring.parse(tokens[i]));
    }

    int[] joltageRequirements = parseInts(tokens[tokens.length - 1]);

    return new Machine(lightsGoal, buttonWirings, joltageRequirements);
  }

  private static int[] parseInts(String s) {
    String[] split = s.substring(1, s.length() - 1).split(",");
    return Stream.of(split).mapToInt(Integer::parseInt).toArray();
  }

  int solvePart1() {
    Queue<ComputationState> queue = new ArrayDeque<>();
    queue.add(new ComputationState(new Lights(), 0, 0));

    while (!queue.isEmpty()) {
      ComputationState state = queue.remove();

      for (int i = state.buttonIndex(); i < buttonWirings.size(); i++) {
        Lights lights = state.lights().toggle(buttonWirings.get(i));
        if (lights.equals(lightsGoal)) {
          return state.depth() + 1;
        } else {
          queue.add(new ComputationState(lights, i + 1, state.depth() + 1));
        }
      }
    }

    throw new IllegalStateException("No solution found");
  }

  private record ComputationState(Lights lights, int buttonIndex, int depth) {
  }
}
