package eu.happycoders.adventofcode2025.day11;

class Device {
  private final String name;
  private final String[] outputNames;

  private VisitedInfo visitedInfo;

  private Device(String name, String[] outputNames) {
    this.name = name;
    this.outputNames = outputNames;
  }

  String name() {
    return name;
  }

  String[] outputNames() {
    return outputNames;
  }

  VisitedInfo visitedInfo() {
    return visitedInfo;
  }

  void setVisistedInfo(VisitedInfo visitedInfo) {
    this.visitedInfo = visitedInfo;
  }

  static Device parse(String line) {
    int colIndex = line.indexOf(":");
    String name = line.substring(0, colIndex);
    String[] outputNames = line.substring(colIndex + 2).split(" ");
    return new Device(name, outputNames);
  }
}
