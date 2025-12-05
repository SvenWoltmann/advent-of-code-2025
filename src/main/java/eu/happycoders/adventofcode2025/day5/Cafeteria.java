package eu.happycoders.adventofcode2025.day5;

import eu.happycoders.adventofcode2025.common.Range;
import eu.happycoders.adventofcode2025.common.RangeSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Cafeteria {
  private Cafeteria() {
  }

  static long solvePart1(List<String> lines) {
    Input input = parseInput(lines);

    return input.ingredientIds()
        .stream()
        .filter(ingredientId -> input.freshIngredientRanges().contains(ingredientId))
        .count();
  }

  static long solvePart2(List<String> lines) {
    Input input = parseInput(lines);

    return input.freshIngredientRanges()
        .stream()
        .mapToLong(Range::getSizeIncluding)
        .sum();
  }

  private static Input parseInput(List<String> lines) {
    Iterator<String> iterator = lines.iterator();

    RangeSet freshIngredientRanges = new RangeSet();
    while (iterator.hasNext()) {
      String line = iterator.next();
      if (line.isEmpty()) {
        break;
      }
      freshIngredientRanges.add(Range.parse(line));
    }

    List<Long> ingredientIds = new ArrayList<>();
    while (iterator.hasNext()) {
      String line = iterator.next();
      ingredientIds.add(Long.parseLong(line));
    }

    return new Input(freshIngredientRanges, ingredientIds);
  }

  private record Input(RangeSet freshIngredientRanges, List<Long> ingredientIds) {
  }
}
