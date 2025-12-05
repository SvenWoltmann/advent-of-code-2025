package eu.happycoders.adventofcode2025.common;

import java.util.stream.LongStream;

public record Range(long from, long to) {
  public LongStream ids() {
    return LongStream.rangeClosed(from, to);
  }

  public static Range parse(String s) {
    String[] split = s.split("-");
    return new Range(Long.parseLong(split[0]), Long.parseLong(split[1]));
  }
}