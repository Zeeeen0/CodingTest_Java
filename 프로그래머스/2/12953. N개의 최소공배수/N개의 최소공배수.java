// 최대공배수 = (n1 * n2) / n1과 n2의 최소공약수
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int num : arr) {
            answer = answer * num / gcd(answer, num);
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}