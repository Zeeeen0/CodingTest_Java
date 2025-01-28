import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.println(sb);
  }

  private static void solve() throws IOException {
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String[] firstLine = br.readLine().split(" ");
      int numberOfDocuments = Integer.parseInt(firstLine[0]);
      int targetIndex = Integer.parseInt(firstLine[1]);

      int[] priorities = parsePriorities(br.readLine());
      PriorityQueue<Integer> pq = createDescPriorityQueue(priorities);

      int printOrder = determinePrintOrder(numberOfDocuments, targetIndex, priorities, pq);
      sb.append(printOrder).append("\n");
    }
  }

  private static int[] parsePriorities(String input) {
    return Arrays.stream(input.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  private static PriorityQueue<Integer> createDescPriorityQueue(int[] priorities) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int priority : priorities) {
      pq.add(priority);
    }
    return pq;
  }

  private static int determinePrintOrder(int numberOfDocuments, int targetIndex, int[] priorities, PriorityQueue<Integer> pq) {
    int printOrder = 0;
    while (!pq.isEmpty()) {
      for (int j = 0; j < numberOfDocuments; j++) {
        if (priorities[j] == pq.peek()) {
          pq.poll();
          printOrder++;
          if (j == targetIndex) {
            return printOrder;
          }
        }
      }
    }
    return -1;
  }
}
