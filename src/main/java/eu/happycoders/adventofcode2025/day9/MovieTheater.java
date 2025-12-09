package eu.happycoders.adventofcode2025.day9;

import eu.happycoders.adventofcode2025.common.Position;

import java.util.List;

final class MovieTheater {
  private MovieTheater() {
  }


  static long solve(List<String> input, boolean switchOutOnlyRedOrGreen) {
    List<Position> redTiles = input.stream().map(Position::parse).toList();
    List<CompressedPosition> compressedRedTiles = PositionsCompressor.compress(redTiles);

    TileFloor tileFloor = switchOutOnlyRedOrGreen ? TileFloor.compute(compressedRedTiles) : null;

    // Brute-force approach: find all pairs of red tiles and compare their areas
    // Time complexity: O(n²), fast enough for the problem size (496 red tiles)
    int numRedTiles = compressedRedTiles.size();
    long maxArea = 0;

    for (int i = 0; i < numRedTiles; i++) {
      CompressedPosition first = compressedRedTiles.get(i);
      for (int j = 1; j < numRedTiles; j++) {
        CompressedPosition second = compressedRedTiles.get(j);
        long area = calculateArea(first, second, tileFloor);
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }

    return maxArea;
  }

  private static long calculateArea(CompressedPosition first, CompressedPosition second, TileFloor tileFloor) {
    int width = Math.abs(second.col() - first.col()) + 1;
    int height = Math.abs(second.row() - first.row()) + 1;

    // If width or height is 1, we know that in between are only green tiles
    if (width == 1 || height == 1 || tileFloor == null || tileFloor.doesNotTouchOutside(first, second)) {
      return (long) width * height;
    } else {
      return -1;
    }
  }
}