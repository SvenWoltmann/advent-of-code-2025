package eu.happycoders.adventofcode2025.day12;

import java.util.ArrayList;
import java.util.List;

record PuzzleInput(List<Present> presents, List<Tree> trees) {

  static PuzzleInput parse(List<String> lines) {
    List<List<String>> blocks = splitByEmptyLines(lines);
    List<Present> presents = blocks.stream().limit(blocks.size() - 1L).map(Present::parse).toList();
    List<Tree> trees = blocks.getLast().stream().map(Tree::parse).toList();
    return new PuzzleInput(presents, trees);
  }

  private static List<List<String>> splitByEmptyLines(List<String> lines) {
    List<List<String>> blocks = new ArrayList<>();
    List<String> currentBlock = new ArrayList<>();
    for (String line : lines) {
      if (line.isBlank()) {
        blocks.add(currentBlock);
        currentBlock = new ArrayList<>();
      } else {
        currentBlock.add(line);
      }
    }
    blocks.add(currentBlock);
    return blocks;
  }
}
