import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 연산의 개수 입력
        int N = scanner.nextInt();

        // PriorityQueue를 사용하여 Min Heap 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 결과 저장을 위한 StringBuilder
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();

            if (x == 0) {
                // 힙이 비어 있을 경우 0 출력
                if (minHeap.isEmpty()) {
                    result.append("0\n");
                } else {
                    // 최소값 추출 후 출력
                    result.append(minHeap.poll()).append("\n");
                }
            } else {
                // 자연수 x를 힙에 추가
                minHeap.add(x);
            }
        }

        // 결과 출력
        System.out.print(result);
    }
}
