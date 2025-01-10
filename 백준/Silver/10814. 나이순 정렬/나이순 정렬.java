import java.io.*;
import java.util.*;

public class Main {
  static class Member {
    int age;
    String name;
    int joinOrder;

    public Member(int age, String name, int joinOrder) {
      this.age = age;
      this.name = name;
      this.joinOrder = joinOrder;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Member> members = new ArrayList<>();

    // 입력 받기
    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int age = Integer.parseInt(input[0]);
      String name = input[1];
      members.add(new Member(age, name, i));
    }

    // 정렬
    Collections.sort(members, new Comparator<Member>() {
      @Override
      public int compare(Member m1, Member m2) {
        if (m1.age == m2.age) {
          return m1.joinOrder - m2.joinOrder; // 나이가 같으면 가입 순서로 정렬
        }
        return m1.age - m2.age; // 나이 순으로 정렬
      }
    });

    // 출력
    StringBuilder sb = new StringBuilder();
    for (Member member : members) {
      sb.append(member.age).append(" ").append(member.name).append("\n");
    }
    System.out.print(sb.toString());

    br.close();
  }
}