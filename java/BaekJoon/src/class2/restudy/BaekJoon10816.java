package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 숫자 카드 2
// 정렬 후 이진탐색 후 결과 idx에서 ++ -- 하면서 카운트 => 시간 초과로 실패
// 1. HashMap 사용해서 데이터 입력 시 바로 카운트 저장
// 2. lowerBound / upperBound 나눠서 이진탐색 후 인덱스 차이 계산
public class BaekJoon10816 {
    int n, m;
    HashMap<Integer, Integer> map;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                result.append(map.get(key)).append(" ");
            } else {
                result.append(0).append(" ");
            }
        }
        System.out.print(result);
    }
}
