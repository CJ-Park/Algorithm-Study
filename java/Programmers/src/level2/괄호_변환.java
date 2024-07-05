package level2;

// 2020 카카오 블라인드
public class 괄호_변환 {
    public String solution(String p) {
        return check(p);
    }

    // 시간 최대 O(n^2) => 10^6 안정권
    private String check(String p) {
        if (p.equals("")) {
            return "";
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p.length(); i++) { // max 1000
            char c = p.charAt(i);
            sb.append(c);

            if (c == '(') {
                count++;

                if (count == 0) { // 균형잡힌 괄호
                    StringBuilder notCorrect = new StringBuilder();
                    notCorrect.append('(');
                    if (i != p.length() - 1) {
                        notCorrect.append(check(p.substring(i + 1)));
                    }
                    notCorrect.append(')');

                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(0);
                    String s = changeWord(sb.toString());

                    notCorrect.append(s);
                    return notCorrect.toString();
                }
            } else {
                count--;

                if (count == 0 && i != p.length() - 1) { // 올바른 괄호
                    sb.append(check(p.substring(i + 1)));
                    break;
                }
            }
        }
        return sb.toString();
    }

    private String changeWord(String s) { // max 1000
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
}
