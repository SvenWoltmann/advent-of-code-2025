package eu.happycoders.adventofcode2025.common;

import java.util.stream.LongStream;

public record Range(long from, long to) {
  public static Range parse(String s) {
    String[] split = s.split("-");
    return new Range(Long.parseLong(split[0]), Long.parseLong(split[1]));
  }

  public LongStream ids() {
    return LongStream.rangeClosed(from, to);
  }

  boolean contains(long value) {
    return value >= from && value <= to;
  }

  public long getSizeIncluding() {
    return to - from + 1;
  }

  Range tryMergeWith(Range other) {
    // this range completely contains the other range?
    if (this.contains(other.from) && this.contains(other.to)) {
      return this;
    }

    // the other range completely contains this range?
    if (other.contains(this.from) && other.contains(this.to)) {
      return other;
    }

    // this range intersects or touches the other range from the left?
    if (this.contains(other.from) || this.to + 1 == other.from) {
      return new Range(this.from, other.to);
    }

    // this range intersects or touches the other range from the right?
    if (this.contains(other.to) || this.from - 1 == other.to) {
      return new Range(other.from, this.to);
    }

    return null;
  }
}