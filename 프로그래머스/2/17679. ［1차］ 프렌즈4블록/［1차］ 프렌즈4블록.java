class Solution {
    public int solution(int m, int n, String[] board) {
        Block block = new Block(m, n, board);
        while (block.checkRemove()) {
            block.removeBlocks();
            block.dropBlocks();
        }
        return block.removedCnt;
    }
}

class Block {
    private int m, n;
    private char[][] blocks;
    private boolean[][] check;
    protected int removedCnt = 0;

    Block(int m, int n, String[] board) {
        this.m = m;
        this.n = n;

        char[][] b = new char[m][n];
        for (int i = 0; i < m; i++) {
            b[i] = board[i].toCharArray();
        }
        this.blocks = b;
    }

    // 1. 2x2 기준 지울 데이터 확인하기
    public boolean checkRemove() {
        boolean canRemove = false;
        this.check = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = blocks[i][j];

                if (c == ' ') {
                    continue;
                }

                if (c == blocks[i][j + 1]
                        && c == blocks[i + 1][j]
                        && c == blocks[i + 1][j + 1]) {
                    check[i][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j] = true;
                    check[i + 1][j + 1] = true;
                    canRemove = true;
                }
            }
        }
        return canRemove;
    }

    // 2. 지우기
    public void removeBlocks() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    blocks[i][j] = ' ';
                    removedCnt++;
                }
            }
        }
    }

    // 3. 아래로 내리기
    public void dropBlocks() {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (blocks[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (blocks[k][j] != ' ') {
                            blocks[i][j] = blocks[k][j];
                            blocks[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }
}