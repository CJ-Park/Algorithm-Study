package level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 거리두기_확인하기 {
    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            result[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return result;
    }

    private boolean checkRoom(String[] place) {
        char[][] room = new char[7][7];
        Queue<Point> queue = new ArrayDeque<>();
        boolean fail = false;

        for (int i = 0; i < place.length; i++) {
            String s = place[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                room[i + 1][j + 1] = c;

                if (c == 'P') {
                    queue.add(new Point(i + 1, j + 1));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (checkAround(p.x + 1, p.y, room) ||
                    checkAround(p.x - 1, p.y, room) ||
                    checkAround(p.x, p.y + 1, room) ||
                    checkAround(p.x, p.y - 1, room)) {
                fail = true;
                break;
            }
        }

        return !fail;
    }

    // 해당 자리 및 사방 확인
    // P X O P X
    // O X O X P
    // O X P O X
    // O X X O P
    // P X P O X
    private boolean checkAround(int x, int y, char[][] room) {
        if (x < 1 || x > 5 || y < 1 || y > 5) {
            return false;
        }
        if (room[x][y] == 'P') { // 바로 붙어있을 경우
            return true;
        }

        if (room[x][y] == 'X') { // 파티션일 경우
            return false;
        }

        int countPerson = 0;

        // 상하좌우 확인 후 countPerson > 1 이 되면 true 리턴
        if (room[x + 1][y] == 'P') {
            countPerson++;
        }
        if (room[x - 1][y] == 'P') {
            countPerson++;
        }
        if (room[x][y + 1] == 'P') {
            countPerson++;
        }
        if (room[x][y - 1] == 'P') {
            countPerson++;
        }

        return countPerson > 1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
