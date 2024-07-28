package level2;

// 2020 카카오 블라인드
/*
- 문자열은 반띵까지 가능 => 이외엔 원본과 같은 결과
- result의 최대값은 압축 하나도 안한것 => s의 길이

1. 1개부터 반띵까지 압축하며 확인
2. 압축결과를 result와 비교
*/
public class 문자열_압축 {
    public int solution(String s) {
        int result = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = compress(s, i);
            result = Math.min(result, compressed.length());
        }

        return result;
    }

    private String compress(String word, int cutSize) {
        StringBuilder sb = new StringBuilder();
        String prev = word.substring(0, cutSize);
        int count = 1;

        for (int i = cutSize; i < word.length(); i += cutSize) {
            String next;

            if (i + cutSize > word.length()) {
                next = word.substring(i);
            } else {
                next = word.substring(i, i + cutSize);
            }

            if (prev.equals(next)) {
                count++;
            } else {
                if (count == 1) {
                    sb.append(prev);
                } else {
                    sb.append(count).append(prev);
                }

                prev = next;
                count = 1;
            }
        }

        if (count == 1) {
            sb.append(prev);
        } else {
            sb.append(count).append(prev);
        }

        return sb.toString();
    }
}
