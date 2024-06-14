package level1;

public class 신규_아이디_추천 {
    static StringBuilder sb = new StringBuilder();

    // 처음 내가 푼 방법
    public String solution(String new_id) {
        String c1_id = check_1(new_id);
        String c2_id = check_2(c1_id);
        String c3_id = check_3(c2_id);
        String c4_id = check_4(c3_id);

        // 5단계
        if (c4_id.equals("")) {
            c4_id = "a";
        }

        // 6단계
        if (c4_id.length() > 15) {
            c4_id = c4_id.substring(0, 15);
            c4_id = check_4(c4_id);
        }

        // 7단계
        int length = c4_id.length();
        char c = c4_id.charAt(length - 1);
        sb.append(c4_id);
        while (length < 3) {
            sb.append(c);
            length++;
        }

        return sb.toString();
    }

    // 소문자 치환
    private String check_1(String id) {
        return id.toLowerCase();
    }

    // 허용 외 문자 제거
    private String check_2(String id) {
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);

            if (Character.isAlphabetic(c) || Character.isDigit(c) ||
                    c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        String res = sb.toString();
        sb.setLength(0);

        return res;
    }

    // 마침표 두번이상 연속으로 나올 경우 하나로 치환
    private String check_3(String id) {
        if (id.length() == 0) {
            return "";
        }

        sb.append(id.charAt(0));

        for (int i = 1; i < id.length(); i++) {
            char before = id.charAt(i - 1);
            char c = id.charAt(i);
            if (before == '.' && c == before) {
                continue;
            }
            sb.append(c);
            before = c;
        }

        String res = sb.toString();
        sb.setLength(0);

        return res;
    }

    // 처음과 끝 마침표 제거
    private String check_4(String id) {
        if (id.startsWith(".")) {
            id = id.substring(1);
        }

        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }

        return id;
    }




    // ===========================================================================================
    // 정규식 + 객체지향적 사고의 답안 (인상깊어서 가져왔음)
    public String solution_2(String new_id) {

        String s = new ID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class ID {
        private String s;

        ID(String s) {
            this.s = s;
        }

        private ID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private ID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private ID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private ID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private ID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private ID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private ID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
