package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N 과 M (12) - 백트래킹
// 정렬과 재귀로 해결
public class BaekJoon15666 {
    int n, m;
    List<Integer> list;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        list = new ArrayList<>(set);
        Collections.sort(list, Integer::compareTo);

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i) + " ";
            getResult(str, i, 1);
        }

        System.out.print(sb);
    }

    public void getResult(String s, int idx, int cnt) {
        if (cnt == m) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            String str = s + list.get(i) + " ";
            getResult(str, i, cnt + 1);
        }
    }
}
