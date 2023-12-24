import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// 명령프롬프트, 브론즈1
public class BaekJoon1032 {
    char[] res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String result = "";
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (i == 0) {
                result = input;
                res = new char[input.length()];
            }

            for (int j = 0; j < input.length(); j++) {
                if (Objects.equals(result.charAt(j), input.charAt(j))) {
                    res[j] = result.charAt(j);
                } else {
                    res[j] = '?';
                }
            }

            for (char c : res) {
                sb.append(c);
            }
            result = sb.toString();
            sb.setLength(0);
        }

        System.out.print(result);
    }
}
