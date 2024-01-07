package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달 - 브루트포스 / 백트래킹
public class BaekJoon15686 {
    int n, liveStore, result;
    List<Point> home = new ArrayList<>();
    List<Point> stores = new ArrayList<>();
    boolean[] openStore;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        liveStore = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1)
                    home.add(new Point(i, j));
                if (input == 2)
                    stores.add(new Point(i, j));
            }
        }

        openStore = new boolean[stores.size()];

        getResult(0, 0);

        System.out.print(result);
    }

    // 재귀 + 백트래킹
    public void getResult(int start, int openCount) {
        if (liveStore == openCount) { // 문 연 가게 개수가 같아질 경우만 집과 치킨집 사이의 최소 거리 구하기
            int totalDistance = 0;

            for (int i = 0; i < home.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < stores.size(); j++) {
                    if (openStore[j]) {
                        Point homeP = home.get(i);
                        Point storeP = stores.get(j);
                        int x = Math.abs(homeP.x - storeP.x);
                        int y = Math.abs(homeP.y - storeP.y);
                        distance = Math.min(x + y, distance);
                    }
                }
                totalDistance += distance;
            }
            result = Math.min(totalDistance, result);
            return;
        }

        // getResult 로 재귀 돌릴 때 인수로 start + 1 이 아닌 i + 1 넘겨서 중복탐색 되는 경우 없도록 해야 됨
        for (int i = start; i < stores.size(); i++) {
            openStore[i] = true;
            getResult(i + 1, openCount + 1);
            openStore[i] = false;
        }
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
