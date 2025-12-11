package eu.happycoders.adventofcode2025.day10;

@SuppressWarnings("java:S6218") // We don't need a `toString` method
record ButtonWiring(int bits, int[] indices) {

  static ButtonWiring parse(String s) {
    int bits = 0;

    String[] split = s.substring(1, s.length() - 1).split(",");
    int[] indices = new int[split.length];

    for (int i = 0; i < split.length; i++) {
      indices[i] = Integer.parseInt(split[i]);
      bits |= 1 << indices[i];
    }

    return new ButtonWiring(bits, indices);
  }
}
