package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서강그라운드 - 플로이드-워셜
public class BaekJoon14938 {
    int n, maxDistance, m, maxItemCount;
    int[][] graph;
    int[] itemCount;
    final int MAX = Integer.MAX_VALUE / 10;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        maxDistance = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        itemCount = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[n1][n2] = dist;
            graph[n2][n1] = dist;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] == MAX || graph[i][k] == MAX)
                        continue;

                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int resultItem = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j] <= maxDistance) {
                    resultItem += itemCount[j];
                }
            }

            maxItemCount = Math.max(maxItemCount, resultItem);
        }

        System.out.print(maxItemCount);
    }
}
