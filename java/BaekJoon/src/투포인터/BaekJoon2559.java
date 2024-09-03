package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
최대 온도 구하기 - 시간복잡도 O(N)
*/
public class BaekJoon2559 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int maxResult = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxResult = sum;

        for (int i = 0; i < n - k; i++) {
            sum -= arr[i];
            sum += arr[i + k];
            maxResult = Math.max(maxResult, sum);
        }

        System.out.println(maxResult);
    }
}
