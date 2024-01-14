package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// N 과 M (5) - 백트래킹

// 사전순 정렬이랬는데 수의 오름차순 정렬이었음
// 원래 list 에 싹 넣고 sort 했는데
// 수의 오름차순이라 arr 먼저 정렬 후 list 에 값 넣어줌
public class BaekJoon15654 {
    int n, m;
    List<String> list = new ArrayList<>(); // 사전순 정렬을 위한 리스트 => ?? 사전순이랬는데 수의 오름차순이었네
    int[] arr; // n 개의 수 담는 공간
    boolean[] visited; // 숫자는 10000 이하

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[10001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            String res = "";

            getList(res, i, 1);
        }

//        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void getList(String res, int idx, int cnt) {
        visited[arr[idx]] = true;

        res = res.concat(arr[idx] + " ");

        if (cnt == m) {
            list.add(res);
            visited[arr[idx]] = false;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[arr[i]])
                getList(res, i, cnt + 1);
        }

        visited[arr[idx]] = false;
    }
}
