class Solution {
    public int[] solution(int[] array) {
        int max = -1;
        int[] answer = new int[2];
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                answer[1] = i;
            }
        }
        
        answer[0] = max;
        
        return answer;
    }
}