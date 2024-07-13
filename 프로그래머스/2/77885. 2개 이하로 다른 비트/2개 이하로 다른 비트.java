class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getNextNumber(numbers[i]);
        }
        
        return answer;
    }

    private long getNextNumber(long n) {
        if (n % 2 == 0) {
            return n + 1;
        }
        
        long smallest = n;
        long mask = 1;
        
        while ((smallest & mask) != 0) {
            mask <<= 1;
        }
        
        smallest |= mask;
        smallest &= ~(mask >> 1);
        
        return smallest;
    }
}