import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Pokedex {

  private final Map<String, Integer> nameToNumber = new HashMap<>();
  private final String[] numberToName;

  public Pokedex(int size) {
    this.numberToName = new String[size + 1];
  }

  public void addPokemon(int number, String name) {
    nameToNumber.put(name, number);
    numberToName[number] = name;
  }

  public String getByNumber(int number) {
    return numberToName[number];
  }

  public int getByName(String name) {
    return nameToNumber.get(name);
  }
}

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    solve();
    System.out.print(result);
  }

  private static void solve() throws IOException {
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    Pokedex pokedex = new Pokedex(N);

    for (int i = 1; i <= N; i++) {
      String pokemon = br.readLine();
      pokedex.addPokemon(i, pokemon);
    }

    for (int i = 0; i < M; i++) {
      String query = br.readLine();
      if (isNumber(query)) {
        result.append(pokedex.getByNumber(Integer.parseInt(query))).append("\n");
      } else {
        result.append(pokedex.getByName(query)).append("\n");
      }
    }
  }

  private static boolean isNumber(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}