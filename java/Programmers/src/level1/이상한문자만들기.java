package level1;

// 공백을 포함한 split
public class 이상한문자만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" ", -1);

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (Character.isLetter(c)) {
                    if (i % 2 == 0) {
                        c = Character.toUpperCase(c);
                    }

                    if (i % 2 == 1) {
                        c = Character.toLowerCase(c);
                    }
                }

                sb.append(c);
            }

            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
