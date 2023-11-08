package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// solved.ac
public class BaekJoon18110 {
    int n, sum, result;
    int[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int removeIdx = Math.toIntExact(Math.round(n * 0.15));

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = removeIdx; i < n - removeIdx; i++) {
            sum += arr[i];
        }
        result = Math.toIntExact(Math.round(sum / (double) (n - (2 * removeIdx))));
        System.out.println(result);
    }
}
