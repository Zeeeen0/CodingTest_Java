import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      List<Point> points = readPoints(br);
      points.sort(Point.getComparator());
      printPoints(points);
    }
  }

  private static List<Point> readPoints(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] xy = br.readLine().split(" ");
      points.add(
          new Point(
              Integer.parseInt(xy[0]),
              Integer.parseInt(xy[1])
          )
      );
    }
    return points;
  }

  private static void printPoints(List<Point> points) {
    points.forEach(System.out::println);
  }
}

class Point {

  private static final String SPACE_DELIMITER = " ";

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return x + SPACE_DELIMITER + y;
  }

  public static Comparator<Point> getComparator() {
    return Comparator.comparing(Point::getY).thenComparing(Point::getX);
  }
}