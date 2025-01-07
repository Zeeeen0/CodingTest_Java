import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");

    long A = Long.parseLong(input[0]); // 낮에 올라가는 높이
    long B = Long.parseLong(input[1]); // 밤에 미끄러지는 높이
    long V = Long.parseLong(input[2]); // 나무 막대의 높이

    long result = calculateDays(A, B, V);
    System.out.println(result);

    br.close();
  }

  public static long calculateDays(long A, long B, long V) {
    // (높이 - 낮에 올라가는 거리) / (하루에 실제로 올라가는 순수 거리) 를 올림한 값 + 1
    return (V - B - 1) / (A - B) + 1;
  }
}