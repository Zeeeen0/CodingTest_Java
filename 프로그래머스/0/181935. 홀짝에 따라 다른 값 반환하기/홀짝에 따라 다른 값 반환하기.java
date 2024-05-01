class Solution {
    public int solution(int n) {
        int sum = 0;
        for (int i = n % 2; i <= n; i += 2) {
            if (n % 2 == 1) {
                sum += i;
            } else {
                sum += (i * i);
            }
        }
        return sum;
    }
}