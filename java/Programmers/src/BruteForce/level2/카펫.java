package BruteForce.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        // 조건 1. x >= y
        // 조건 2. x * y = brown + yellow
        // 조건 3. (x - 2) * (y - 2) = yellow
        int[] answer = new int[2];
        int total = brown + yellow;
        int x = 1;

        while (true) {
            if (total % x == 0 && x >= total / x ) {
                if ((x - 2) * (total / x - 2) == yellow) {
                    break;
                }
            }

            x++;
        }

        answer[0] = x;
        answer[1] = total / x;

        return answer;
    }
}
