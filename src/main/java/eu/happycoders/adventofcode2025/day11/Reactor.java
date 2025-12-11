package eu.happycoders.adventofcode2025.day11;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

final class Reactor {
  private Reactor() {
  }

  static long solvePart1(List<String> input) {
    Map<String, Device> map = input.stream()
        .map(Device::parse)
        .collect(Collectors.toMap(Device::name, Function.identity()));

    Device start = map.get("you");

    return traverse(start, map).totalPaths();
  }

  static long solvePart2(List<String> input) {
    Map<String, Device> map = input.stream()
        .map(Device::parse)
        .collect(Collectors.toMap(Device::name, Function.identity()));

    Device start = map.get("svr");

    return traverse(start, map).pathsWithBothFoundFromHere();
  }

  private static VisitedInfo traverse(Device from, Map<String, Device> map) {
    VisitedInfo visitedInfo = new VisitedInfo();
    boolean dac = from.name().equals("dac");
    boolean fft = from.name().equals("fft");

    for (String output : from.outputNames()) {
      if (output.equals("out")) {
        visitedInfo.increase(dac, fft);
      } else {
        Device next = map.get(output);

        // Go into the recursion only if we haven't been at this node before
        VisitedInfo nextVisitedInfo = next.visitedInfo();
        if (nextVisitedInfo == null) {
          nextVisitedInfo = traverse(next, map);
          next.setVisistedInfo(nextVisitedInfo);
        }

        visitedInfo.add(nextVisitedInfo, dac, fft);
      }
    }

    return visitedInfo;
  }
}