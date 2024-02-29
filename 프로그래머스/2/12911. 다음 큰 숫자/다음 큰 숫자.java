class Solution {
    public int solution(int n) {
        int nCount = Integer.bitCount(n); // 1의 개수
        while (true) {
            n++;
            int count = Integer.bitCount(n);
            if (nCount == count) return n;
        }
    }
}