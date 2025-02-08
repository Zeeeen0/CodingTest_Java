import java.util.*;

class Clothes {
    private final String name;
    private final String type;

    public Clothes(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Clothes{name='" + name + "', type='" + type + "'}";
    }
}

class WardrobeManager {
    private final Map<String, Integer> typeCount;

    public WardrobeManager() {
        this.typeCount = new HashMap<>();
    }

    public void addClothes(Clothes clothes) {
        String type = clothes.getType();
        typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
    }

    public long calculateCombinations() {
        if (typeCount.isEmpty()) {
            return 0;
        }

        long combinations = 1;
        for (int count : typeCount.values()) {
            combinations *= (count + 1); // 해당 종류를 입지 않는 경우 포함
        }
        return combinations - 1; // 알몸인 경우 제외
    }
}

class TestCase {
    private final int clothesCount;
    private final WardrobeManager wardrobeManager;

    public TestCase(Scanner scanner) {
        this.clothesCount = scanner.nextInt();
        this.wardrobeManager = new WardrobeManager();
        processInput(scanner);
    }

    private void processInput(Scanner scanner) {
        for (int i = 0; i < clothesCount; i++) {
            String name = scanner.next();
            String type = scanner.next();
            wardrobeManager.addClothes(new Clothes(name, type));
        }
    }

    public long solve() {
        return wardrobeManager.calculateCombinations();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            TestCase testCase = new TestCase(scanner);
            System.out.println(testCase.solve());
        }

        scanner.close();
    }
}