class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int[] idx = new int[]{0, 0};
        
        for (String g : goal) {
            if (idx[0] < cards1.length && g.equals(cards1[idx[0]])) {
                idx[0]++;
                continue;
            }
            if (idx[1] < cards2.length && g.equals(cards2[idx[1]])) {
                idx[1]++;
                continue;
            }
            return "No";
        }
        
        return "Yes";
    }
}