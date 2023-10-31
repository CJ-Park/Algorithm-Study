package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Queue 방식의 리스트 활용
// 요소 삭제해 가면서 리스트 줄이기
public class BaekJoon11866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int idx = 0;

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        // 1 2 3 4 5 6 7 => 인덱스 2 == K - 1 % 7
        // 1 2 4 5 6 7   => 인덱스 4 == (2 + (K - 1)) % 6
        // 1 2 4 5 7     => 인덱스 1 == (4 + (K - 1)) % 5
        // 1 4 5 7       => 3 == (1 + K - 1) % 4
        // 1 4 5         => 2 == (3 + K - 1) % 3
        // 1 4           => 0 == (2 + K - 1) % 2
        // 4             => 0 == (0 + K - 1) % 1
        while(!arr.isEmpty()) {
            sb.append(", ");
            idx = (idx + (K - 1)) % arr.size();
            sb.append(arr.get(idx));
            arr.remove(idx);
        }
        sb.delete(1, 3).append(">");
        System.out.print(sb);
    }
}
