import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.println(sb);
  }

  private static void solve() throws IOException {
    int n = Integer.parseInt(br.readLine());
    Person[] people = new Person[n];
  
    for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        int weight = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);
        people[i] = new Person(weight, height);
    }
  
    for (int i = 0; i < n; i++) {
        int rank = 1;
        for (int j = 0; j < n; j++) {
            if (i != j && people[j].isBiggerThan(people[i])) {
                rank++;
            }
        }
        sb.append(rank).append(" ");
    }
  }
  
  private static class Person {
      int weight, height;
  
      Person(int weight, int height) {
          this.weight = weight;
          this.height = height;
      }
  
      boolean isBiggerThan(Person other) {
          return this.weight > other.weight && this.height > other.height;
      }
  }
}
