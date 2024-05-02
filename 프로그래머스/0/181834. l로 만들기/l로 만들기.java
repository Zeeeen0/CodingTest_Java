class Solution {
    public String solution(String myString) {
        char target = 'l';

        for (char c = 'a'; c < target; c++) {
            myString = myString.replaceAll(String.valueOf(c), "l");
        }

        return myString;
    }
}