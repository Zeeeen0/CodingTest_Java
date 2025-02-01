import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // N개의 정수를 배열에 저장
        String[] input = br.readLine().split(" ");
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        
        // M 입력 받기
        int M = Integer.parseInt(br.readLine());
        
        // M개의 숫자에 대해 존재 여부 확인
        input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (numbers.contains(Integer.parseInt(input[i]))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        
        System.out.print(sb.toString());
        br.close();
    }
}