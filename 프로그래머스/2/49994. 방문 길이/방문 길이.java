import java.util.*;

class Solution {
    int MAX_SIZE = 5;
    ArrayList<Move> moveList;

    class Move {
        int fromX, fromY, toX, toY;

        public Move(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String dirs) {
        moveList  = new ArrayList<>();
        HashMap<Character, Point> direction = new HashMap<>();
        direction.put('U', new Point(0, 1));
        direction.put('D', new Point(0, -1));
        direction.put('R', new Point(1, 0));
        direction.put('L', new Point(-1, 0));

        Point cur = new Point(0, 0);

        for (char c : dirs.toCharArray()) {
            Point t = direction.get(c);
            int x = cur.x + t.x;
            int y = cur.y + t.y;

            if (x < -MAX_SIZE || x > MAX_SIZE || y < -MAX_SIZE || y > MAX_SIZE) {
                continue;
            }

            if (!isVisited(cur.x, cur.y, x, y)) {
                moveList.add(new Move(cur.x, cur.y, x, y));
            }

            cur = new Point(x, y);
        }

        return moveList.size();
    }

    private boolean isVisited(int x1, int y1, int x2, int y2) {
        for (Move m : moveList) {
            // from -> to, to -> from 2가지 방향을 1개의 길로 보기에 둘 다 체크
            if (m.fromX == x1 && m.fromY == y1 && m.toX == x2 && m.toY == y2) return true;
            if (m.fromX == x2 && m.fromY == y2 && m.toX == x1 && m.toY == y1) return true;
        }

        return false;
    }
}