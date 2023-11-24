package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 바이러스 - 그래프 탐색 문제
public class BaekJoon2606 {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int n, connection, count;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // graph 의 각 list 초기화
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 완성시키기
        for (int i = 0; i < connection; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번 컴퓨터로 인해 바이러스에 걸린 컴퓨터 개수
        searchVirus(1);
        System.out.println(count);
    }

    public void searchVirus(int num) {
        if (!visited[num]) { // 방문한적이 없음 -> 방문처리 후 이어진 컴퓨터 찾으면서 count++
            visited[num] = true;
            for (int i : graph[num]) {
                if (!visited[i]) {
                    count++;
                    searchVirus(i);
                }
            }
        }
    }
}
