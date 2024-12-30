import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 단어의 개수 N 입력 받기
        int N = sc.nextInt();
        
        // 단어들을 저장할 HashSet (중복 제거를 위해 Set 사용)
        Set<String> wordSet = new HashSet<>();
        
        // N개의 단어 입력 받기
        for (int i = 0; i < N; i++) {
            wordSet.add(sc.next());
        }
        
        // Set을 List로 변환하여 정렬
        List<String> words = new ArrayList<>(wordSet);
        
        // 정렬: 길이가 짧은 순, 길이가 같으면 사전 순
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이가 다르면 길이 순으로 정렬
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                // 길이가 같으면 사전 순으로 정렬
                return s1.compareTo(s2);
            }
        });
        
        // 정렬된 결과 출력
        for (String word : words) {
            System.out.println(word);
        }
        
        sc.close();
    }
}