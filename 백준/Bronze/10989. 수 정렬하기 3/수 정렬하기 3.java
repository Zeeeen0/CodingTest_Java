import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 카운팅 배열 (입력값은 10,000 이하의 자연수)
        int[] count = new int[10001];
        
        // 각 숫자의 출현 횟수를 카운팅
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }
        
        // 버퍼 효율을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        
        // 카운팅 배열을 순회하며 결과 생성
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        
        // 결과 출력
        bw.write(sb.toString());
        
        // 리소스 정리
        br.close();
        bw.flush();
        bw.close();
    }
}