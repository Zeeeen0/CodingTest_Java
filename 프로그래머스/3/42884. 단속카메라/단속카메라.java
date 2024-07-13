import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // 종료지점 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        
        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 카메라 위치보다 진입 지점이 뒤에 있는 경우 새로운 카메라 설치
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}