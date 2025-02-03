import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final int BOARD_SIZE = 8;
  private static final String[] PATTERNS = {"WBWBWBWB", "BWBWBWBW"};
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    ChessBoard board = ChessBoard.readBoard(br, BOARD_SIZE, PATTERNS);
    int result = board.findMinimumRecoloring();
    sb.append(result);
    System.out.println(sb);
  }
}

class ChessBoard {

  private final int rows;
  private final int cols;
  private final char[][] board;
  private final int boardSize;
  private final String[] patterns;

  private ChessBoard(int rows, int cols, char[][] board, int boardSize, String[] patterns) {
    this.rows = rows;
    this.cols = cols;
    this.board = board;
    this.boardSize = boardSize;
    this.patterns = patterns;
  }

  public static ChessBoard readBoard(BufferedReader br, int boardSize, String[] patterns)
      throws IOException {
    String[] size = br.readLine().split(" ");
    int rows = Integer.parseInt(size[0]);
    int cols = Integer.parseInt(size[1]);

    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      board[i] = br.readLine().toCharArray();
    }

    return new ChessBoard(rows, cols, board, boardSize, patterns);
  }

  public int findMinimumRecoloring() {
    int minRecoloring = Integer.MAX_VALUE;

    for (int i = 0; i <= rows - boardSize; i++) {
      for (int j = 0; j <= cols - boardSize; j++) {
        minRecoloring = Math.min(minRecoloring, calculateRecoloringCost(i, j));
      }
    }

    return minRecoloring;
  }

  private int calculateRecoloringCost(int startX, int startY) {
    int countPattern1 = 0;
    int countPattern2 = 0;

    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++) {
        char original = board[startX + x][startY + y];
        if (original != patterns[x % 2].charAt(y)) {
          countPattern1++;
        }
        if (original != patterns[(x + 1) % 2].charAt(y)) {
          countPattern2++;
        }
      }
    }

    return Math.min(countPattern1, countPattern2);
  }
}
