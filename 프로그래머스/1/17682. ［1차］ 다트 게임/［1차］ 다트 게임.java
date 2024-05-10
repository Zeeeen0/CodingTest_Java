import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int idx = -1;
        String[] dart = dartResult.split("");
        for (int i = 0; i < dart.length; i++) {
            if (dart[i].matches("[0-9]")) {
                idx++;
                score[idx] = Integer.parseInt(dart[i]);
                if (dart[i + 1].matches("[0-9]")) {
                    score[idx] *= 10;
                    i++;
                }
            }

            switch(dart[i]) {
                case "D":
                    score[idx] = (int) Math.pow(score[idx], 2);
                    break;
                case "T":
                    score[idx] = (int) Math.pow(score[idx], 3);
                    break;
                case "*":
                    score[idx] *= 2;
                    if (idx - 1 >= 0) score[idx - 1] *= 2; // 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다
                    break;
                case "#":
                    score[idx] *= -1;
                    break;
            }
        }

        return Arrays.stream(score).sum();
    }
}