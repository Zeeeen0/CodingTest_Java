class Solution {
    public boolean solution(String s) {
        return s.chars().allMatch(Character::isDigit)
            && (s.length() == 4 || s.length() == 6);
    }
}