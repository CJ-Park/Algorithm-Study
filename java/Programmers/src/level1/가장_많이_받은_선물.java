package level1;

import java.util.Arrays;
import java.util.HashMap;

// 2024 카카오 인턴
public class 가장_많이_받은_선물 {
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        int[][] graph = new int[size][size];
        int[] point = new int[size];
        int[] takeNext = new int[size];

        HashMap<String, Integer> idx = new HashMap<>();

        for (int i = 0; i < size; i++) {
            idx.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] s = gift.split(" ");
            int i = idx.get(s[0]);
            int j = idx.get(s[1]);

            graph[i][j]++;
            point[i]++;
            point[j]--;
        }

        // 그래프는 절반만 탐색하면 됨
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] < graph[j][i]) { // j가 선물 더 많이 줌
                    takeNext[j]++;
                }

                if (graph[i][j] > graph[j][i]) { // i가 선물 더 많이 줌
                    takeNext[i]++;
                }

                if (graph[i][j] == graph[j][i]) { // 같은 개수 주고받음 or 안주고받음
                    if (point[i] > point[j]) { // i가 선물지수 더 높음
                        takeNext[i]++;
                    }
                    if (point[i] < point[j]) { // j가 선물지수 더 높음
                        takeNext[j]++;
                    }
                }
            }
        }

        // 다음달 선물 배열 정렬 후 제일 큰 값 반환
        Arrays.sort(takeNext);
        return takeNext[size - 1];
    }
}
