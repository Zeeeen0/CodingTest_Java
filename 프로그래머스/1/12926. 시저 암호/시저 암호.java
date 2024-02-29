class Solution {
    public String solution(String s, int n) {
        // A-Z : 65-90
        // a-z : 97-122
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = (int) c;
            if (65 <= i && i <= 90) {
                i = 65 + ((i - 65 + n) % 26);
            }
            if (97 <= i && i <= 122) {
                i = 97 + ((i - 97 + n) % 26);
            }
            sb.append((char) i);
        }
        return sb.toString();
    }
}