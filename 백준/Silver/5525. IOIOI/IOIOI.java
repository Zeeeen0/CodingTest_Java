import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        String S = br.readLine().trim();
        
        int result = countPatterns(S, N);
        System.out.println(result);
    }
    
    /**
     * 문자열 S에서 PN 패턴이 몇 번 등장하는지 계산합니다.
     */
    private static int countPatterns(String S, int N) {
        int answer = 0;
        int patternCount = 0;
        
        for (int i = 1; i < S.length() - 1;) {
            // 'IOI' 패턴을 찾음
            if (S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                patternCount++;
                i += 2; // 다음 O 위치로 이동 (I O I 에서 마지막 I 다음 위치로)
                
                // 필요한 패턴 개수에 도달하면 카운트 증가
                if (patternCount == N) {
                    answer++;
                    patternCount--; // 중첩된 패턴을 위해 하나 감소
                }
            } else {
                // 패턴이 끊기면 처음부터 다시 시작
                patternCount = 0;
                i++;
            }
        }
        
        return answer;
    }
}
