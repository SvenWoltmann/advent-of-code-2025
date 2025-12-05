package eu.happycoders.adventofcode2025.day2;

import eu.happycoders.adventofcode2025.common.Range;

import java.util.stream.Stream;

final class GiftShop {
  private GiftShop() {
  }

  static long solve(String input, int maxRepetitions) {
    return Stream.of(input.split(","))
        .map(Range::parse)
        .flatMapToLong(Range::ids)
        .filter(id -> isInvalidId(id, maxRepetitions))
        .sum();
  }

  private static boolean isInvalidId(long id, int maxRepetitions) {
    String idString = Long.toString(id);
    int idLength = idString.length();
    int minSequenceLength = Math.ceilDiv(idLength, maxRepetitions);
    int maxSequenceLength = idLength / 2;

    for (int sequenceLength = minSequenceLength; sequenceLength <= maxSequenceLength; sequenceLength++) {
      if (containsOnlyRepetitions(idString, idLength, sequenceLength)) {
        return true;
      }
    }

    return false;
  }

  private static boolean containsOnlyRepetitions(String idString, int idLength, int sequenceLength) {
    // fast path: ID length is not a multiple of sequence length
    if (idLength % sequenceLength != 0) {
      return false;
    }

    String sequence = idString.substring(0, sequenceLength);
    for (int i = sequenceLength; i < idLength; i += sequenceLength) {
      if (!sequence.equals(idString.substring(i, i + sequenceLength))) {
        return false;
      }
    }

    return true;
  }
}
