import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 목표량 {
    char[] str;
    String result = "";
    String today;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        today = br.readLine();
        str = today.toCharArray();

        Arrays.sort(str);

        recur(0, new StringBuilder(), new boolean[str.length]);
        System.out.print(result.equals("") ? "0" : result);
    }

    private void recur(int depth, StringBuilder sb, boolean[] visited) {
        if (depth == str.length && Integer.parseInt(sb.toString()) > Integer.parseInt(today)) {
            if (result.equals("") || Integer.parseInt(sb.toString()) < Integer.parseInt(result)) {
                result = sb.toString();
            }
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(str[i]);

                recur(depth + 1, sb, visited);

                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
