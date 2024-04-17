class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        // 가로세로 최소 길이 = 3
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    return new int[]{col, row};
                }
            }
        }
        
        return null;
    }
}