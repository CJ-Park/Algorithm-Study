package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
숫자 야구 - 실버3
 */
public class BaekJoon2503 {
    int T;
    List<Baseball> games = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            games.add(new Baseball(num, strike, ball));
        }

        for (int i = 123; i <= 987; i++) { // 결과값으로 나오는 모든 경우 확인
            checkNumber(i);
        }

        System.out.println(result.size());
    }

    private void checkNumber(int num) {
        String number = String.valueOf(num);
        String[] split = number.split("");

        // 겹치는 수 있는 경우 or 숫자 0이 들어간 경우 리턴
        if (split[0].equals(split[1]) || split[0].equals(split[2])
                || split[1].equals(split[2]) || split[0].equals("0") ||
                split[1].equals("0") || split[2].equals("0")) {
            return;
        }

        if (check(number)) {
            result.add(num);
        }
    }

    private boolean check (String num) {
        for (Baseball round : games) {
            if (!round.pass(num)) { // 해당 라운드 통과 못할 경우
                return false;
            }
        }
        return true;
    }

    static class Baseball {
        int number;
        int strike;
        int ball;

        public Baseball(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean pass(String num) {
            String[] s = num.split("");
            String[] input = String.valueOf(this.number).split("");

            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (s[i].equals(input[j])) { // 같은 숫자 발견
                        if (i == j) { // 위치까지 같음
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                        break;
                    }
                }
            }

            return strikeCount == this.strike && ballCount == this.ball;
        }
    }
}
