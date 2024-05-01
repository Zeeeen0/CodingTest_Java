class Solution {
    public int solution(int price) {
        if (price < 100000) return price;
        if (price < 300000) return (int) (price * 0.95);
        if (price < 500000) return (int) (price * 0.9);
        return (int) (price * 0.8);
    }
}