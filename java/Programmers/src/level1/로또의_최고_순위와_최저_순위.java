package level1;

// 2021 데브 매칭
public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. boolean 배열의 당첨번호 idx 에 true 값 갖도록 함
        // 2. lottos 에서 0의 개수 카운팅해서 저장
        // 3. lottos 순회하며 win 배열에서 당첨번호가 있는지 확인하며 리턴카운팅 증가
        // 4. {7 - (0의 개수 카운팅 + 리턴 카운팅), 7 - 리턴 카운팅} 로 반환
        // 5. 요소의 결과가 7이라면 6으로 변환
        int zeroCount = 0;
        int returnCount = 0;
        boolean[] win = new boolean[46];
        int[] result = new int[2];

        // 1
        for (int winNum : win_nums) {
            win[winNum] = true;
        }

        // 2, 3
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            }

            if (win[lotto]) {
                returnCount++;
            }
        }

        // 4
        result[0] = 7 - (zeroCount + returnCount);
        result[1] = 7 - returnCount;

        // 5
        for (int i = 0; i < 2; i++) {
            if (result[i] == 7) {
                result[i] = 6;
            }
        }

        return result;
    }
}
