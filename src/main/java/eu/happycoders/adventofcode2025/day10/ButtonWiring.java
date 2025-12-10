package eu.happycoders.adventofcode2025.day10;

record ButtonWiring(int bits) {

  static ButtonWiring parse(String s) {
    int bits = 0;

    String[] split = s.substring(1, s.length() - 1).split(",");
    for (int i = 0; i < split.length; i++) {
      int lightIndex = Integer.parseInt(split[i]);
      bits |= 1 << lightIndex;
    }

    return new ButtonWiring(bits);
  }
}
