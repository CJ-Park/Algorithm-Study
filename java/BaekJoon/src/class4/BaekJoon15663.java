package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// N 과 M (9) - 백트래킹
// 정렬 시 숫자 기준 정렬임
// Set -> List 변환 후 정렬해서 String 기준 정렬됨 ===> Set 을 중복 비교 용도로만 사용하고 sb 에 문자열 순서대로 즉시 저장
public class BaekJoon15663 {
    int n, m;
    int[] arr;
    boolean[] visited;
    Set<String> list = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 1 2 3 3 5 / 3
        // 1 2 3 / 1 2 5 / 1 3 2 / 1 3 3 / 1 3 5 / 1 5 2 / 1 5 3
        for (int i = 0; i < n; i++) {
            String s = "";
            getList(s, i, 1);
        }

        System.out.print(sb);
    }

    public void getList(String s, int idx, int cnt) {
        if (visited[idx])
            return;

        visited[idx] = true;
        String str = s + arr[idx] + " ";

        if (cnt == m) {
            if (!list.contains(str)) {
                list.add(str);
                sb.append(str).append("\n");
            }
            visited[idx] = false;
            return;
        }

        for (int i = 0; i < n; i++) {
            getList(str, i, cnt + 1);
        }

        visited[idx] = false;
    }
}
