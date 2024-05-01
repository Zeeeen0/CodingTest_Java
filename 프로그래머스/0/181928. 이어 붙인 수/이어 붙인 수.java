class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        for (int num : num_list) {
            if (num % 2 == 1) odd += num;
            else even += num;
        }
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}