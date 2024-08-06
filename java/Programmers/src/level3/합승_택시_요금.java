package level3;

/*
시작지점 ~ 특정 지점까지의 최단거리 전부 구함
1 - 10
2 - 66
3 - 51
4 - 0
5 - 34
6 - 35

특정 지점을 시작점으로 잡고 A와 B까지의 최단거리 구하기
1 - A 25 / B 63
2 - A 48 / B 0
3 - A 26 / B 22
4 - A 35 / B 63
5 - A 2 / B 46
6 - A 0 / B 48

특정 지점 ~ A와 B까지의 비용 합계 리스트를 구해서 최소값 구하기
비용합계
1 - 10 + 25 + 63 = 98
2 - 66 + 48 + 0 = 114
3 - 51 + 26 + 22 = 99
4 - 35 + 63 = 98
5 - 34 + 2 + 46 = 82
6 - 35 + 0 + 48 = 83

=> 플로이드-워셜 알고리즘 사용 or 시작지점, a지점, b지점 각각에서 특정 지점까지의 최단거리 합계 비교
=> 플로이드-워셜로 해결했음
*/
public class 합승_택시_요금 {
    int[][] minCost;
    int MAX = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        minCost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                minCost[i][j] = MAX;

                if (i == j) {
                    minCost[i][j] = 0;
                }
            }
        }

        for (int[] info : fares) {
            int start = info[0];
            int end = info[1];
            int cost = info[2];

            minCost[start][end] = cost;
            minCost[end][start] = cost;
        }

        getMinCost(n);

        int result = MAX;

        // 시작지점 ~ 특정지점 + 특정지점 ~ A + 특정지점 ~ B
        for (int i = 1; i <= n; i++) {
            int fromStart = minCost[s][i];
            int toA = minCost[i][a];
            int toB = minCost[i][b];

            if (fromStart == MAX || toA == MAX || toB == MAX) {
                continue;
            }

            result = Math.min(fromStart + toA + toB, result);
        }

        return result;
    }

    private void getMinCost(int n) {
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                for (int k = 1; k <= n; k++) {
                    if (minCost[i][j] == MAX || minCost[j][k] == MAX) {
                        continue;
                    }

                    if (minCost[i][k] > minCost[i][j] + minCost[j][k]) {
                        minCost[i][k] = minCost[i][j] + minCost[j][k];
                    }
                }
            }
        }
    }
}
