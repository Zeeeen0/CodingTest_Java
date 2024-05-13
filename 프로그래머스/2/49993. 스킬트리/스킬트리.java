class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^" + skill + "]";
        
        for (String st : skill_trees) {
            String s = st.replaceAll(regex, "");
            System.out.print(st + " | " + s);
            if (skill.startsWith(s)) {
                System.out.print(" | !!!!!!!");
                answer++;
            }
            System.out.println();
        }
        
        return answer;
    }
}