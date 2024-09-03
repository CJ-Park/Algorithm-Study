package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
n 은 최대 10만 => 시간복잡도 O(N)
숫자 받아서 배열에 넣고 정렬
-99 -98 -1 4 98
-99 (0) 98 (4) = -1 < 0
-98 (1) 98 (4) = 0 == 0
i < j 만 진행
arr[i] + arr[j] < 0 이면 i++
arr[i] + arr[j] > 0 이면 j++
arr[i] + arr[j] == 0 이면 결과 반환 후 종료
*/
public class BaekJoon2470 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int minSum = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int resStart = 0, resEnd = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == 0) {
                resStart = arr[start];
                resEnd = arr[end];
                break;
            }

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                resStart = arr[start];
                resEnd = arr[end];
            }

            if (sum < 0) {
                start++;
            }

            if (sum > 0) {
                end--;
            }
        }

        System.out.println(resStart + " " + resEnd);
    }
}
