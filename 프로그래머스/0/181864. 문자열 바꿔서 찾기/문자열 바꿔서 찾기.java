class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "b");
        myString = myString.replaceAll("B", "a");
        myString = myString.toUpperCase();
        return myString.contains(pat) ? 1 : 0;
    }
}