class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int t = a;
            a = b;
            b = (t + b) % 1234567;
        }
        return b;
    }
}