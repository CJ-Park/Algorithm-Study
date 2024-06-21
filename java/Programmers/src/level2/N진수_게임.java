package level2;

// 2018 카카오 블라인드
public class N진수_게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int number = 0;
        int i = 0;
        int startIdx = p - 1;

        // 사람 4명 2번째
        // 0 1 2 3 4 5 6 7 8 9 A B C D E F
        // '1, 5, 9, D'
        // 인덱스 1, 5, 9, 13, 17
        // 길이 16
        while (result.length() != t) {
            if (word.length() < i + 1) {
                word.append(Integer.toString(number, n).toUpperCase());
                number++;
            }

            if ((i - startIdx) % m == 0) {
                result.append(word.charAt(i));
            }
            i++;
        }

        return result.toString();
    }
}
