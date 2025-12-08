package eu.happycoders.adventofcode2025.day8;

public record Point3D(long x, long y, long z) {

  public static Point3D parse(String s) {
    String[] split = s.split(",");
    return new Point3D(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2]));
  }

  public double distanceTo(Point3D other) {
    long deltaX = other.x() - x;
    long deltaY = other.y() - y;
    long deltaZ = other.z() - z;

    return Math.sqrt((double) deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
  }
}
