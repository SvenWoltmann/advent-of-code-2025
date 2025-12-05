package eu.happycoders.adventofcode2025.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class InputReader {
  private InputReader() {
  }

  public static List<String> readInput(String name) {
    try {
      return readInputInternal(name);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static List<String> readInputInternal(String name) throws IOException {
    ClassLoader classLoader = InputReader.class.getClassLoader();
    List<String> result = new ArrayList<>();

    try (InputStream inputStream = classLoader.getResourceAsStream(name);
         InputStreamReader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
         BufferedReader reader = new BufferedReader(in)) {
      String line;
      while ((line = reader.readLine()) != null) {
        result.add(line);
      }
    }

    return List.copyOf(result);
  }
}
