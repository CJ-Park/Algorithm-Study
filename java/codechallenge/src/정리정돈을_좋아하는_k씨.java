import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정리정돈을_좋아하는_k씨 {
    int[] arr;
    StringBuilder result = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken()) - 1;
            int endIdx = Integer.parseInt(st.nextToken()) - 1;
            int targetIdx = Integer.parseInt(st.nextToken()) - 1;

            getResult(startIdx, endIdx, targetIdx);
        }
        result.deleteCharAt(result.length() - 1);

        System.out.print(result);
    }

    private void getResult(int start, int end, int target) {
        int[] arr2 = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            arr2[i - start] = arr[i];
        }

        Arrays.sort(arr2);
        result.append(arr2[target]).append("\n");
    }
}
