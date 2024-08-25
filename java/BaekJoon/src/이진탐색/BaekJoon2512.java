package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
예산 - 실버2
 */
public class BaekJoon2512 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr[arr.length - 1];

        int maxResult = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if (sum <= total) {
                start = mid + 1;
                maxResult = Math.max(maxResult, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(maxResult);
    }
}
