package eu.happycoders.adventofcode2025.day10;

record Lights(int bits) {

  Lights() {
    this(0);
  }

  static Lights parse(String s) {
    int bits = 0;
    int numLights = s.length() - 2;
    for (int i = 0; i < numLights; i++) {
      if (s.charAt(i + 1) == '#') {
        bits |= 1 << i;
      }
    }
    return new Lights(bits);
  }

  Lights toggle(ButtonWiring buttonWiring) {
    return new Lights(bits ^ buttonWiring.bits());
  }
}
