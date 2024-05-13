import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (String file : files) {
            list.add(new File(file));
        }
        Collections.sort(list);
        
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).fileName;
        }
        return answer;
    }
}

class File implements Comparable<File> {
    String head;
    String number;
    String tail;
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
        String[] split = splitFile();
        this.head = split[0];
        this.number = split[1];
    }

    private String[] splitFile() {
        String fName = fileName.toLowerCase();
        String head = fName.split("[0-9]")[0];
        String number = fName.substring(head.length());
        return new String[]{head, number};
    }

    @Override
    public int compareTo(File o) {

        int result = this.head.compareTo(o.head);

        // head 값이 서로 같다면 number 값으로 비교
        if (result == 0) {
            int number1 = this.get5Numbers();
            int number2 = o.get5Numbers();
            return number1 - number2;
        }
        return result;
    }

    private int get5Numbers() {
        StringBuilder sb = new StringBuilder();

        for (char c : number.toCharArray()) {
            if (Character.isDigit(c) && sb.length() <= 5) {
                sb.append(c);
            } else {
                break;
            }
        }
        String num = sb.toString();
        return Integer.parseInt(num);
    }
}