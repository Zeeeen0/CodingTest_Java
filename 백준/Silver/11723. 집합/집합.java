import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());  // 연산의 수 M
        int set = 0;  // 비트마스크를 이용한 집합 표현 (1 ~ 20까지 포함 여부)
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set |= (1 << (x - 1));  // x 번째 비트를 1로 설정
            } 
            else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set &= ~(1 << (x - 1));  // x 번째 비트를 0으로 설정
            } 
            else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((set & (1 << (x - 1))) != 0 ? "1\n" : "0\n");  // x 번째 비트가 1인지 확인
            } 
            else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                set ^= (1 << (x - 1));  // x 번째 비트를 반전시킴
            } 
            else if (command.equals("all")) {
                set = (1 << 20) - 1;  // 모든 비트를 1로 설정
            } 
            else if (command.equals("empty")) {
                set = 0;  // 모든 비트를 0으로 설정
            }
        }
        
        System.out.print(sb.toString());
    }
}
