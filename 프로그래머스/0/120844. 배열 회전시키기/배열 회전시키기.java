class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] answer = new int[n];
        switch (direction) {
            case "right":
                answer[0] = numbers[n - 1];
                for (int i = 1; i < n; i++) {
                    answer[i] = numbers[i - 1];
                }
                break;
            case "left":
                answer[n - 1] = numbers[0];
                for (int i = 0; i < n - 1; i++) {
                    answer[i] = numbers[i + 1];
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        
        return answer;
    }
}