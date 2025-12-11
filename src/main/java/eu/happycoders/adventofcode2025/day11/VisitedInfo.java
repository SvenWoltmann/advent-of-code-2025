package eu.happycoders.adventofcode2025.day11;

class VisitedInfo {
  private long pathsWithBothFoundFromHere;
  private long pathsWithOnlyDacFromHere;
  private long pathsWithOnlyFftFromHere;
  private long pathsWithNoneFromHere;

  void increase(boolean dac, boolean fft) {
    if (dac) {
      pathsWithOnlyDacFromHere++;
    } else if (fft) {
      pathsWithOnlyFftFromHere++;
    } else {
      pathsWithNoneFromHere++;
    }
  }

  void add(VisitedInfo other, boolean dac, boolean fft) {
    if (dac) {
      pathsWithBothFoundFromHere += other.pathsWithBothFoundFromHere + other.pathsWithOnlyFftFromHere;
      pathsWithOnlyDacFromHere += other.pathsWithOnlyDacFromHere + other.pathsWithNoneFromHere;
    } else if (fft) {
      pathsWithBothFoundFromHere += other.pathsWithBothFoundFromHere + other.pathsWithOnlyDacFromHere;
      pathsWithOnlyFftFromHere += other.pathsWithOnlyFftFromHere + other.pathsWithNoneFromHere;
    } else {
      pathsWithBothFoundFromHere += other.pathsWithBothFoundFromHere;
      pathsWithOnlyDacFromHere += other.pathsWithOnlyDacFromHere;
      pathsWithOnlyFftFromHere += other.pathsWithOnlyFftFromHere;
      pathsWithNoneFromHere += other.pathsWithNoneFromHere;
    }
  }

  long pathsWithBothFoundFromHere() {
    return pathsWithBothFoundFromHere;
  }

  long totalPaths() {
    return pathsWithBothFoundFromHere
           + pathsWithOnlyDacFromHere
           + pathsWithOnlyFftFromHere
           + pathsWithNoneFromHere;
  }
}
