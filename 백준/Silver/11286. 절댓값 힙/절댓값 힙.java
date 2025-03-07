import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        // 절댓값 힙을 구현하기 위한 우선순위 큐 생성
        // 우선순위: 1. 절댓값이 작은 순, 2. 실제 값이 작은 순
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            
            // 절댓값이 같으면 실제 값이 작은 것을 우선
            if (absA == absB) {
                return a - b;
            }
            // 절댓값이 다르면 절댓값이 작은 것을 우선
            return absA - absB;
        });
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                // x가 0이면 배열에서 절댓값이 가장 작은 값을 출력하고 제거
                if (absHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(absHeap.poll()).append("\n");
                }
            } else {
                // x가 0이 아니면 배열에 x 추가
                absHeap.add(x);
            }
        }
        
        System.out.print(sb);
    }
}