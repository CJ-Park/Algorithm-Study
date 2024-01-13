package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 거짓말 - 그래프 탐색
// 그래프 + 재귀로 해결
public class BaekJoon1043 {
    int n, m, result;
    boolean[] truth;
    boolean[] visited;
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    String[] str;
    StringTokenizer st;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = new String[m];
        truth = new boolean[n + 1];
        visited = new boolean[n + 1];

        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);

        for (int i = 1; i <= num; i++) {
            int idx = Integer.parseInt(s[i]);
            truth[idx] = true;
        }

        // 간선 정보 기반 graph 생성
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            str[i] = line;

            makeGraph(line);
        }

        // graph 기반으로 truth 체크
        for (int i = 0; i < m; i++) {
            String line = str[i];

            checkTruth(line);
        }

        // 파티 체크
        for (int i = 0; i < m; i++) {
            String line = str[i];

            if (checkParty(line)) {
                result += 1;
            }
        }

        System.out.print(result);
    }

    // 간선 정보 기반 graph 생성
    public void makeGraph(String s) {
        Set<Integer> list = new HashSet<>();

        st = new StringTokenizer(s);

        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            int idx = Integer.parseInt(st.nextToken());
            list.add(idx);
        }

        for (int idx : list) {
            Set<Integer> info = graph.getOrDefault(idx, new HashSet<>());
            info.addAll(list);
            graph.put(idx, info);
        }
    }

    // graph 기반 true 체크
    public void checkTruth(String s) {
        st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if (truth[idx]) {
                propagation(idx);
            }
        }
    }

    // 해당 idx 의 사람으로부터 진실 전파
    public void propagation(int person) {
        if (visited[person])
            return;

        visited[person] = true;
        truth[person] = true;

        Set<Integer> nextPeople = graph.get(person);
        for (int next : nextPeople) {
            propagation(next);
        }
    }

    // 파티 체크하는 메서드
    public boolean checkParty(String s) {
        st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            int idx = Integer.parseInt(st.nextToken());

            if (truth[idx])
                return false;
        }

        return true;
    }
}
