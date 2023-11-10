package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기
// 이진탐색 UpperBound 문제
public class BaekJoon1654 {
    int k, n;
    long start, end, mid;
    int[] lan;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken()); // 랜선의 개수
        n = Integer.parseInt(st.nextToken()); // 잘려지는 개수
        lan = new int[k]; // 갖고 있는 랜선 배열

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan);

        start = 1;
        end = lan[lan.length - 1];

        while (start <= end) {
            mid = (start + end) / 2; // 201 201
            // 랜선 개수의 합 변수
            long sum = 0;

            // mid 로 line 나눈 몫 => 랜선 개수의 합
            for (int line : lan) {
                sum += line / mid;
                if (sum > n) break;
            }

            // 랜선 개수의 합 sum 이 n 보다 크거나 같다 => 랜선 길이를 늘려서 랜선 개수를 줄여야 됨
            if (sum >= n) {
                start = mid + 1;
            } else { // 랜선 길이를 줄여서 랜선 개수를 늘려야 됨
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
