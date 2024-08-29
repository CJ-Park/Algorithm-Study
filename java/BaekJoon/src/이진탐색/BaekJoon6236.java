package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
용돈 관리
m번 돈을 뽑는다
만약에 m 번보다 안뽑았으면 금액이 너무 큼 => 금액 줄이기
m 번보다 많이 뽑았으면 금액이 너무 작음 => 금액 올리기
m 번이라면 최소금액 찾아야되므로 금액 줄이면서 최소값 구하기
*/
public class BaekJoon6236 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int startCost = 0;
        int endCost = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            startCost = Math.max(startCost, arr[i]);
            endCost += arr[i];
        }

        int min = endCost;

        // 토탈 시간복잡도 = 10^7 이내
        while (startCost <= endCost) { // 이분탐색 시간복잡도 log10000 => 대략 14-15번
            int midCost = (startCost + endCost) / 2;
            int myCost = midCost;
            int withdrawCount = 1;

            for (int i = 0; i < n; i++) { // n 은 10^5
                if (myCost < arr[i]) { // 가진 돈보다 쓸 돈이 더 큼
                    withdrawCount++; // 출금 다시하기
                    myCost = midCost;
                }
                myCost -= arr[i];
            }

            if (withdrawCount <= m) {
                if (withdrawCount == m) {
                    min = Math.min(min, midCost);
                }
                endCost = midCost - 1;
            } else {
                startCost = midCost + 1;
            }
        }

        System.out.println(min);
    }
}
