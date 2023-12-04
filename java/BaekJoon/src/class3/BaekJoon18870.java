package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 좌표 압축
public class BaekJoon18870 {
    Map<Integer, Integer> map = new HashMap<>();
    int n;
    int[] sortingArr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        sortingArr = new int[n];
        int[] originArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            originArr[i] = sortingArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortingArr);
        int minusIdx = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sortingArr[i])) {
                minusIdx++;
                continue;
            }
            map.put(sortingArr[i], i - minusIdx);
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(originArr[i])).append(" ");
        }
        System.out.print(sb);
    }
}
