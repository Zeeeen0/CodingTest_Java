class Solution {
    public int solution(int n, String control) {
        n += control.length() - control.replace(String.valueOf("w"), "").length();
        n -= control.length() - control.replace(String.valueOf("s"), "").length();
        n += 10 * (control.length() - control.replace(String.valueOf("d"), "").length());
        n -= 10 * (control.length() - control.replace(String.valueOf("a"), "").length());
        return n;
    }
}