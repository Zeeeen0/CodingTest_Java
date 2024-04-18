class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        int num = 1;

        for (int i = 1; i < food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }
        
        
        String answer = sb.toString() + "0" + sb.reverse().toString();
        
        return answer;
    }
}