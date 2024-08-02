package level3.re;

/*
    회전 / 이동
    1. 회전메소드 (시계방향 90도)
    2. 이동메소드 (상하좌우)

    최대 N + M - 1 칸까지 허용가능
    1 0 0
    0 0 0
    0 0 1

    0 1 1
    1 1 1
    1 1 1
    n,m
    => 3,3 = 7 / 4,3 = 8 / 4,4 = 10 / 5,3 = 9 / 5,4 = 11
    => 2*(m-1) + n
    */

//
public class 자물쇠와_열쇠 {
    int[][] myMap;
    int[][] myKey;
    int lockSize;
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        lockSize = lock.length;
        int size = 2 * (m - 1) + lockSize;
        myMap = new int[size][size];
        myKey = key;

        // myMap 완성
        int x = 0;
        int y = 0;
        for (int i = m-1; i < m-1+lockSize; i++) {
            for (int j = m-1; j < m-1+lockSize; j++) {
                myMap[i][j] = lock[x][y];
                y++;
            }
            y = 0;
            x++;
        }

        // 열쇠 회전시키면서 처음부터 넣기 => 1이 겹치지 않으면서 가운데 lock 이 전부 1로 바뀌면 성공
        for (int i = 0; i < 4; i++) {
            turnKey();
            if (test()) {
                return true;
            }
        }

        return false;
    }

    // 열쇠 시계방향 90도 회전
    // 1. 대각선 기준 요소 바꾸기
    // 2. 각 행 뒤집기
    private void turnKey() {
        int size = myKey.length;
        int[][] newKey = new int[size][size];

        // 대각선 기준 요소 바꿈
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newKey[j][i] = myKey[i][j];
            }
        }

        // 각 행 뒤집기
        // 1 2 3 4 5
        // 5 4 3 2 1
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = newKey[i][j];
                newKey[i][j] = newKey[i][size - 1 - j];
                newKey[i][size - 1 - j] = temp;
            }
        }

        myKey = newKey;
    }

    // 열쇠 처음부터 끝까지 테스트
    private boolean test() {
        int checkSize = myMap.length - myKey.length + 1;

        // 열쇠와 자물쇠 확인 (i, j 가 열쇠의 0,0 지점이 됨) => 이동역할
        for (int i = 0; i < checkSize; i++) {
            for (int j = 0; j < checkSize; j++) {
                if (checkKey(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 열쇠를 꽂을 수 있는지 확인
    private boolean checkKey(int x, int y) { // x, y는 열쇠의 0, 0 시작 좌표
        // 열쇠 1, 자물쇠 1 => 불가능
        int keySize = myKey.length;
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                if (myKey[i][j] == 1 && myMap[i + x][j + y] == 1) {
                    return false;
                }
            }
        }

        return validateLock(x, y);
    }

    // 열쇠 넣었을 경우 가운데에 위치한 자물쇠 검사
    private boolean validateLock(int x, int y) {
        int keySize = myKey.length;
        int size = myMap.length;
        int start = keySize - 1;

        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = myMap[i][j];
            }
        }

        for (int i = x; i < x + keySize; i++) {
            for (int j = y; j < y + keySize; j++) {
                map[i][j] += myKey[i - x][j - y];
            }
        }

        for (int i = start; i < start + lockSize; i++) {
            for (int j = start; j < start + lockSize; j++) {
                if (map[i][j] < 1) {
                    return false;
                }
            }
        }

        return true;
    }
}

