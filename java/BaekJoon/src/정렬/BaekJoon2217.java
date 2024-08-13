package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
로프 - 실버4
 */
public class BaekJoon2217 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (n - i));
        }

        System.out.println(max);
    }
}
