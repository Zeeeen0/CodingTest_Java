class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) { // 왼쪽 끝
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) { // 오른쪽 끝
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else { // 중간
                    triangle[i][j] += Math.max(
                        triangle[i - 1][j - 1],
                        triangle[i - 1][j]
                    );
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, triangle[len - 1][i]);
        }
        return answer;
    }
}