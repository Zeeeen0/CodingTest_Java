class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            if (canIntoWallet(wallet, bill)) {
                break;
            }
            answer++;
            bill = makeHalfSize(bill);
        }
        return answer;
    }
    
    private boolean canIntoWallet(int[] wallet, int[] bill) {
        return bill[0] <= wallet[0] && bill[1] <= wallet[1]
               || bill[1] <= wallet[0] && bill[0] <= wallet[1];
    }
    
    private int[] makeHalfSize(int[] bill) {
        if (bill[0] > bill[1]) {
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        }
        return bill;
    }
}