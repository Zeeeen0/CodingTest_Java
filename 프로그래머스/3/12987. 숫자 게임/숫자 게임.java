import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        // 순서 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 최적의 승리 값 구하기
        int answer = 0;
        int len = A.length - 1;
        int idx = len;

        for (int i = len; i >= 0; i--) {
            if (A[i] < B[idx]) {
                answer++;
                idx--;
            }
        }
        
        return answer;
    }
}