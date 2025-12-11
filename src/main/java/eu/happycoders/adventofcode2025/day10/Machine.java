package eu.happycoders.adventofcode2025.day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

final class Machine {
  private final Lights lightsGoal;
  private final List<ButtonWiring> buttonWirings;
  private final int numButtonWirings;
  private final int[] joltageGoal;

  private Machine(Lights lightsGoal, List<ButtonWiring> buttonWirings, int[] joltageGoal) {
    this.lightsGoal = lightsGoal;
    this.buttonWirings = buttonWirings;
    this.numButtonWirings = buttonWirings.size();
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

      for (int i = state.buttonIndex(); i < numButtonWirings; i++) {
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

  int solvePart2() {
    int[][] matrix = createMatrix();

    List<int[]> solutions = new GaussianElimination(matrix).solve();
    if (solutions.isEmpty()) {
      throw new IllegalStateException("No solutions found");
    }

    return getMinSteps(solutions);
  }

  private int[][] createMatrix() {
    int numRows = joltageGoal.length;
    int numCols = buttonWirings.size();

    int[][] matrix = new int[numRows][numCols + 1];

    for (int cols = 0; cols < numCols; cols++) {
      ButtonWiring buttonWiring = buttonWirings.get(cols);
      for (int lightIndex : buttonWiring.indices()) {
        matrix[lightIndex][cols] = 1;
      }
    }
    for (int row = 0; row < numRows; row++) {
      matrix[row][numCols] = joltageGoal[row];
    }
    return matrix;
  }

  private static int getMinSteps(List<int[]> solutions) {
    int minSteps = Integer.MAX_VALUE;
    for (int[] solution : solutions) {
      int sum = 0;
      for (int i = 0; i < solution.length; i++) {
        sum += solution[i];
      }
      if (sum < minSteps) minSteps = sum;
    }
    return minSteps;
  }
}
