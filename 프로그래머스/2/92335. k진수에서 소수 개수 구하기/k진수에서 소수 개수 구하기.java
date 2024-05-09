class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n, k); // k진법 변환
        for (String s : num.split("0")) {
            if ("".equals(s)) continue;
            if (isPrime(s)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(String s) {
        long n = Long.parseLong(s);
        
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}