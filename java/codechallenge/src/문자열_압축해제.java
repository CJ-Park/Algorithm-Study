import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀
public class 문자열_압축해제 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String zipCode = br.readLine();

        System.out.print(unZip(zipCode).length());
    }

    private String unZip(String code) {
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        int multiple = 0;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '(') {
                multiple = code.charAt(i - 1) - '0';
                prefix = code.substring(0, i - 1);
                int count = 1;
                int k = i + 1;

                while (count > 0) {
                    if (code.charAt(k) == '(') {
                        count++;
                    }
                    if (code.charAt(k) == ')') {
                        count--;
                    }
                    k++;
                }

                String inside = unZip(code.substring(i + 1, k - 1));
                sb.append(prefix);
                for (int j = 0; j < multiple; j++) {
                    sb.append(inside);
                }

                i = k - 1;
            }
        }

        if (sb.length() == 0) {
            return code;
        } else {
            return sb.toString();
        }
    }
}
